try{    
    String url = "http://localhost:8983/solr/jcg/update/json?commit=true";
    URL obj = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("Accept", "*/*");
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    String data ="[{\"id\":\"978-0641723445\",\"apple_t\":{\"set\":\"abc\"}}]";
    OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
    out.write(data);
    out.close();
    System.out.println("input: "+conn.getInputStream());
} catch (Exception e) {
    e.printStackTrace();
}