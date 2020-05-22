private void testIt() {
    String https_url = "https://www.virustotal.com/en/file/7b6b268cbca9d421aabba5f08533d3dcaba50e0f7887b07ef2bd66bf218b35ff/analysis/";        
    URL url;
    try{
        url = new URL(https_url);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        con.setRequestProperty("accept-language", "en-US,en;q=0.8");
        con.setRequestProperty("accept", "text/html");
        //May need to use connect() if connection is not established
        //con.connect();

        // dumpl all cert info
        print_https_cert(con);
        System.out.println(con);
        // dump all the content
        print_content(con);
    } catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }
}