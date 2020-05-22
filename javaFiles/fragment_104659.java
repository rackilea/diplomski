public static void main(String[]args){
    System.out.println("Connecting...");
    try {
        Socket request=new Socket("127.0.0.1", 1234);
        System.out.println("Connected.");
        request.close();
    } catch (IOException e){
        e.printStackTrace();
    }
}