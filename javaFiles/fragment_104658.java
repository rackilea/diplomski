public static void main(String[]args) throws IOException{
    System.out.println("Connecting...");
    Socket request=new Socket("127.0.0.1", 1234);
    System.out.println("Connected.");
    request.close();
}