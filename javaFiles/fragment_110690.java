while ((str = br.readLine()) != null){
    // If we receive a command of "bye" the RemoteControl is instructing
    // the RemoteReceiver to close the connection.
    if (str.equalsIgnoreCase("bye")){
        socket.close();
            break;
    }
    System.out.println("Processing command " + str);
    pw.println(client.message(str));
}