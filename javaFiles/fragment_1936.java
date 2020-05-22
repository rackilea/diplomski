public class Serveur {
    public static void main(String[] args) {
        ServerSocket sock = null;
        Socket link = null;
        BufferedReader input = null;
        PrintWriter output = null;

        try {
            sock = new ServerSocket(9890);
            link = sock.accept();
            input = new BufferedReader(new InputStreamReader(link.getInputStream()));
            output = new PrintWriter(link.getOutputStream());
            String str, rstr;
            while(true){
                System.out.println("entered while loop");
                str = input.readLine();
                System.out.println("we received : " + str);
                rstr="";
                for (int i = 0; i < str.length(); i++)
                    rstr = str.charAt(i) + rstr;
                System.out.println("we will send to the client : " + rstr);
                output.println(rstr);

                output.flush();
                System.out.println("sent");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}