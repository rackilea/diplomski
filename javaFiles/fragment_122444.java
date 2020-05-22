public class MyCrawler implements Runnable {

    URI uri;



    public MyCrawler(String url) {
         this.uri = URI.create(url);
    }

    @Override
    public void run() {

        try{
            VisitPage(url);

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    private void VisitPage(String url){

        List<String> linksOnthisPage = new ArrayList<>();

        if(!url.contains("javascript") && !url.contains("#")){

            try{
                Document doc = Jsoup.connect(url).timeout(0).get();
                Elements linkTags = doc.select("a[href]");

                for(Element e : linkTags){
                    String link = e.attr("href");
                    if(!link.contains("#") && !link.contains("javascript") && !link.equals(url)){
                        if(link.startsWith("http") || link.startsWith("www")){
                            if(link.contains(uri.getHost())){
                                linksOnthisPage.add(link);
                            }else{
                                System.out.println("SOME OTHER WEBSITE -- " + link);
                            }

                        }else if(link.startsWith("/")){
                            link = url + link.substring(1, link.length());
                            linksOnthisPage.add(link);
                        }else{
                            System.out.println("LINK IGNORED DUE TO  -- " + url);
                        }
                    }else{
                        System.out.println("LINK IGNORED -- " + url);
                    }
                }
                System.out.println("\n\nLinks found in \"" + url+ "\" : " + linksOnthisPage.size());

            }catch(Exception e){
                System.out.println("EXCEPTION -- " + url);
                return;
            }
        }else{
            System.out.println("UNWANTED URL -- " + url);
        }
    }

}