String url = "http://www.flipkart.com/moto-g-3rd-generation/p/itme9ysjr7mfry3n?pid=MOBE6KK93JG5WKB2&cmpid=content_mobile_8965229628_gmc_pla&tgi=sem%2C1%2CG%2C11214002%2Cg%2Csearch%2C%2C50314733420%2C1o1%2C%2C%2Cc%2C%2C%2C%2C%2C%2C%2C&gclid=COXtgdLyiMoCFUyhaAodIawO8w";   

        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements imageElements = doc.select("img.productImage");

            for(Element e : imageElements){
                System.out.println(e.attr("data-src"));
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();