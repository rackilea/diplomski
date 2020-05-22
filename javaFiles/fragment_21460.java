public static String sendGetReqForList(HttpGet get){
    DefaultHttpClient httpClient = new DefaultHttpClient();
    StringBuilder  result = new StringBuilder();
    HttpResponse response = null;
    try {
         response = httpClient.execute(get);
    } catch (Exception e) {   
        e.printStackTrace();
    }
    InputStream input = null;
    try {
        input = new BufferedInputStream(response.getEntity().getContent());
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    byte data[] = new byte[40000];
    int currentByteReadCount = 0;
    /** read response from input stream */
    try {
        while ((currentByteReadCount = input.read(data)) != -1) {
            String readData = new String(data, 0, currentByteReadCount);
            result.append(readData);
            if (readData.indexOf("}~{") >= 0) {
                System.out.println("got json obj from data");
            }
        }   
    } catch (IOException e) {
        e.printStackTrace();
    }
    try {
        input.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    /** transform response into JSONArray */
    return result.toString();
}