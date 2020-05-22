HttpClient httpClient = HttpClients.createDefault();    

        HttpGet get = new HttpGet("http://redu.su/download_file.php?id=7745333&filename=k-j-yesudas-mavapanisa-silpa.mp3&ts=130944042611814004&hash=b825427b3a63b28c8a4ba3b2a34294fb");
        get.setHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36");
        get.setHeader(HttpHeaders.REFERER, "http://redmp3.cc/7745324/k-j-yesudas-sreeragamo.html");

        HttpResponse res = httpClient.execute(get); 
        System.out.println(res.getStatusLine());