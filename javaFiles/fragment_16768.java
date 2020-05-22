public class Server {

    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(81);
        while(true){
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
            DataOutputStream out = new DataOutputStream( s.getOutputStream() );
            while (true) {
                System.out.println( "recieved: "+ in.readLine()  );
                out.writeBytes( "200\n" );
                out.flush();
            }
        }
    }
}