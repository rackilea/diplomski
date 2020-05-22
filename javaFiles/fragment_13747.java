public class HandleClient implements Runnable{
Socket socket;

HandleClient(Socket socket){
    this.socket = socket;
}

public void run() {
    try{
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        double radius;  

        while(true){
            radius = inputFromClient.readDouble();
            double area = radius * radius * Math.PI;
            outputToClient.writeDouble(area);
        }
    }catch(Exception e) {}
}
}