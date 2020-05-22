socket = ss.accept();
in = new BufferedReader(new InputStreamReader(socket.getInputStream());
String line = "";
while ( true) { 
    line = in.readLine();
    System.out.println("you input is :" + line); 
    if ( "Bye".equals(line) ) 
        break;
}