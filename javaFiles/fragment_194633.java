try{
    new Socket("cloudnine1999.no-ip.org", 43594).close();
}catch(IOException ex){
    // Server probably down, restart it...
}catch(Exception ex){
    // Some  other problem, likely DNS or security related.
}