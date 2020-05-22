public class ClientSide {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);

            ArrayList<Process> my =  new ArrayList<Process>();
            my.add(new Process("Test1"));
            my.add(new Process("Test2"));
            try
            {
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(my);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}