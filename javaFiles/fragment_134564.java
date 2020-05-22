/**
* Protocol value could be http:// or https://
*/
boolean usesProtocol(String url,String protocol){
    boolean uses = false;
    try{
        URL u = new URL( protocol.concat(url) );
        URLConnection con = u.openConnection();
        con.connect();
        // the following line will be hit only if the 
        // supplied protocol is supported
        uses = true;
    }catch(MalformedURLException e){
        // new URL() failed
        // user has made a typing error
    }catch(IOException e){
        // openConnection() failed
        // the supplied protocol is not supported
    }finally{
        return uses;
    }
}