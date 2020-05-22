HttpURLConnection con;
InputStream is;
try{
    con=((HttpURLConnection)new URL(app_url).openConnection());
    con.setRequestProperty("Cookie",cookie);
    is=con.openStream();
    //recv code
}finally{
    if(is!=null){try{is.close();}catch(IOException e){}}
    if(con!=null){try{con.close();}catch(IOException e){}
}