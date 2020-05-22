// Put this code somewhere in the Client class so that when it receives something,
// it can be added to the `JTextArea`
while ((fromServer = in.readLine()) != null) 
{
    // You seems like missed the part that sends it to the textArea
    System.out.println("Server: " + fromServer);
    // Here send the received thing to your textarea, which goes something like this
    String str = "Server : " + fromServer + "\n";
    tarea.append(str);

    if (fromServer.equals("Bye."))
        break;

    // You can remove this part and put it inside the textField's actionPerformed method. 
    fromUser = stdIn.readLine();
    if (fromUser != null) 
    {
        System.out.println("Client: " + fromUser);
        out.println(fromUser);
    }
}