url = new URL(urlString);
       uc = url.openConnection();
       uc.addRequestProperty("User-Agent", 
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

       uc.connect();
       uc.getInputStream();
       BufferedInputStream in = new BufferedInputStream(uc.getInputStream());