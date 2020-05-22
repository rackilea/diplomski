public class Imaps  {
     private static BufferedReader in = null;
     private static PrintWriter out = null;
     private static Socket client;
     public static void main (String []arg){
    SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    try {
        client = (SSLSocket) sslsocketfactory.createSocket("imap.gmail.com", 993);
        System.out.println("Connect to Host");

    }
    catch(IOException e) {
        System.out.println("Unable to listen on ports");
        System.exit(+1);
    }
    try {
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        out.println("abcd CAPABILITY");
        String response =  (String) in.readLine();
        System.out.println("Server: " + response);

        out.println("efgh STARTTLS"); //tls part does not work but will not cause any problems being there.
        response =  (String) in.readLine();
        System.out.println("Server: " + response);

        String payload3 = "a001 login username @gmail.com password";
        out.println(payload3);

        response =  (String) in.readLine();
        System.out.println("Server: " + response);
        response =  (String) in.readLine();
        System.out.println("Server: " + response);
        response =  (String) in.readLine();
        System.out.println("Server: " + response);
        //should say success if you enter correct password.


        String payload5 = "a002 select inbox";
        //String payload5 = "a002 select inbox";
        out.println(payload5);

        response =   (String) in.readLine();
        System.out.println("Server: " + response);
        response =  (String) in.readLine();
        System.out.println("Server: " + response);
        response =  (String) in.readLine();
        System.out.println("Server: " + response);
        response =   (String) in.readLine();
        System.out.println("Server: " + response);


    }
    catch(IOException e) {
        System.out.println("Read failed");
        System.exit(+1);
    }