public void stopRunTomcat(){
    try{
        Socket s = new Socket(server,8005);
        if(s.isConnected()){
            PrintWriter print = new PrintWriter(s.getOutputStream(),true);
            //Stop tomcat if it is already started
            print.println("SHUTDOWN"); 
            print.close();
            s.close();
        }
        //Run tomcat 
        Runtime.getRuntime().exec(System.getProperty("catalina.home")+"\\bin\\startup.sh");
    }catch (Exception ex){
        ex.printStackTrace();
    }
}