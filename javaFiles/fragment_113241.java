public static void main(String[] args) throws UnsupportedEncodingException {
    // TODO Auto-generated method stub
    //HTTPRequestPoster a = new HTTPRequestPoster();//
    HTTPRequestPoster astring = new HTTPRequestPoster ();
    String param = "query=Person";
    String result = astring.sendGetRequest("http://ws.nju.edu.cn/falcons/api/classsearch.jsp", param);

    System.out.println(result);
}