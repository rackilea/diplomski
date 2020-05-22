String inputLine;
    URL link = new URL("http://www.ammanu.edu.jo/English/Articles/newsArticle.aspx?id=2935");
    URLConnection con = link.openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

    BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream(),"UTF-8"));

    while ((inputLine = in.readLine()) != null){
        System.out.println(inputLine);
    }
    in.close();