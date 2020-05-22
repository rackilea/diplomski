//In your code after status check you need to do like this
if (myConnection.getResopnseCode() == 200) {
    BufferedReader br=new BufferedReader(responseBodyReader);
    String read = null, entireResponse = "";
    StringBuffer sb = new StringBuffer();
    while((read = br.readLine()) != null) {
        sb.append(read);
    }
    entireResponse = sb.toString();

    //You need to change name of response class
    Response response = new Gson().fromJson(entireResponse , Response.class);

}