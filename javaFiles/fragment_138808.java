public void ping (String entryIpAddress){
    try{    
         String command ="ping  "+entryIpAddress;
         Process process = Runtime.getRuntime().exec(command);
         process.getOutputStream();

    }catch(Exception e){}
}