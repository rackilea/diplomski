public class ServerSide {

    public static void main(String[] args) {
        try
        {
            ServerSocket myServerSocket = new ServerSocket(9999);
            Socket skt = myServerSocket.accept();
            List<Process> objects = null;
            try {
                ObjectInputStream objectInput = new ObjectInputStream(skt.getInputStream());
                try {
                    Object object = objectInput.readObject();
                    objects =  (ArrayList<Process>) object;
                    System.out.println(objects);
                } catch (ClassNotFoundException e) {             
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}