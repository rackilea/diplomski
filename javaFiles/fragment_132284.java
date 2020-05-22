public class Client {
    public static void main(String[] args) {
            System.out.println(" Starting Client ");
            try(Socket socket = new Socket("localhost", 55555)) {
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("Hello from client");
                printWriter.println("Conected, Yes!");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}