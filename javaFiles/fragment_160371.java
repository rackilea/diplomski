public class ClientWala {

    public static void main(String[] args) throws Exception{

        Boolean b = true;
    Socket s = new Socket("127.0.0.1", 4444);

    System.out.println("connected: "+s.isConnected());


    OutputStream output = s.getOutputStream();
    PrintWriter pw = new PrintWriter(output,true);

    // to write data to server
    while(b){

        if (!b){

             System.exit(0);
        }

        else {
            pw.write(new Scanner(System.in).nextLine());
        }
    }


    // to read data from server
    InputStream input   = s.getInputStream();
    InputStreamReader isr = new InputStreamReader(input);
    BufferedReader br = new BufferedReader(isr);
    String data = null;

    while ((data = br.readLine())!=null){

        // Print it using sysout, or do whatever you want with the incoming data from server

    }




    }
}