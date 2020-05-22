private void setUpNetworking(){
        System.out.println("test");
        try{
        sock  = new Socket("127.0.0.1",4242);
        writer = new PrintWriter(sock.getOutputStream());
        }
        catch(UnknownHostException uhe){
            System.out.println("test1");
            uhe.printStackTrace();
        }
        catch(IOException ioe){
            System.out.println("test2");
            ioe.getMessage();
        }
        finally{
            if(writer !=null){
                writer.close();
            }
        }
        System.out.println(writer);
}