public class Client
{
public static void main(String[] args) throws IOException
{
    final int SBAP_PORT = 8080;
    try (Socket s = new Socket("localhost", SBAP_PORT))
    {
        InputStream instream = s.getInputStream();
        OutputStream outstream = s.getOutputStream();

        //Scanner in = new Scanner(instream);
        PrintWriter out = new PrintWriter(outstream);

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        System.out.println("Command: " + command); 


        while(!command.equalsIgnoreCase("QUIT")) {
            out.print(command+"\n");
            out.flush();
            //String response = in.nextLine();  // i am getting error here.
            int i = 0;
            char c;    
            while(( i = instream.read())!=-1) {

                // converts integer to character
                c = (char)i;

                // prints character
                System.out.print(c);
            }



            command = scanner.nextLine();
        }
        command = "QUIT";
        System.out.println(command);
        out.print(command);
        out.flush();
    }
}
}