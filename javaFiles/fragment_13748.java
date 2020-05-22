public static void main(String[] args){
    try{

        //System.out.println(add);
        Socket socket = new Socket("localhost",8000);
        Scanner input = new Scanner(System.in);
        DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());
        double radius;
        System.out.println("Client running at IP address: "+socket.getLocalAddress().toString() +"and port number: "+socket.getLocalPort());


        System.out.println("Enter the value of radius");
        radius = input.nextDouble();

        System.out.println("Writing input");
        outputToServer.writeDouble(radius);
        System.out.println(inputFromServer.readDouble());
    }catch (Exception E){}
}