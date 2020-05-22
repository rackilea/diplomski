public HashMap<String, String> fetchWithJsoup(String url, String iniUrl, int redirCount)
                                        throws IOException
{
    HashMap<String, String> returnObj = new HashMap<>();

    Connection con;
    try{
        con = Jsoup.connect(url);
    }catch(IllegalArgumentException ex){
        if(ex.getMessage().contains("Malformed URL")){
            System.err.println("Malformed URL:: "
                +ex.getClass().getName()+": "+ex.getMessage()+" > "+iniUrl);
        }else{
            Logger.getLogger(ContentGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
        returnObj.put(RETURN_FINAL_URL, url);
        returnObj.put(RETURN_BODY, "");
        return returnObj;
    }

    con.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:10.0.2) Gecko/20100101 Firefox/10.0.2");

    con.timeout(Config.HTTP_CONNECTION_TIMEOUT_TIME);
    Document doc = con.get();

    String uri = doc.baseUri();
    returnObj.put(RETURN_FINAL_URL, uri);

    Elements redirEle = doc.head().select("meta[http-equiv=refresh]");
    if(redirEle.size() > 0){
        String content = redirEle.get(0).attr("content");
        Pattern pattern = Pattern.compile("^.*URL=(.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        if (matcher.matches() && matcher.groupCount() > 0) {
            String redirectUrl = matcher.group(1);
            if(redirectUrl.startsWith("'")){
                /*removes single quotes of urls within single quotes*/
                redirectUrl = redirectUrl.replaceAll("(^')|('$)","");
            }
            if(redirectUrl.startsWith("/")){
                String[] splitedUrl = url.split("/");
                redirectUrl = splitedUrl[0]+"//"+splitedUrl[2]+redirectUrl;
            }
            if(!redirectUrl.equals(url)){
                redirCount++;
                if(redirCount < Config.MAX_REDIRECT_COUNT){
                    return fetchWithJsoup(redirectUrl, iniUrl, redirCount);
                }
            }
        }
    }

    HTMLDocument htmlDoc = new HTMLDocument(doc.html());
    String body = "";
    try{
        if(htmlDoc != null){
            body = ArticleExtractor.INSTANCE.getText(htmlDoc.toInputSource());
        }
    }catch(OutOfMemoryError ex){
        System.err.println("OutOfMemoryError while extracting text !!!!!!!!");
        System.gc();
    } catch (BoilerpipeProcessingException ex) {
        Logger.getLogger(ContentGetter.class.getName()).log(Level.SEVERE, null, ex);
    }
    returnObj.put(RETURN_BODY, body);

    return returnObj;
}