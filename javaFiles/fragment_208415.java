while(true){
        /* Flushing buffer */
        String SvMessage;
        while (!receiver.ready()){} //wait for buffer
        /* Printing the resulting response from the server */
        while (receiver.ready()){
            SvMessage = receiver.readLine();
            System.out.println(SvMessage);
        }

        /* Get input message from the user */
        String userMessage = "hello";

        /* If the user inputs "exit", then the program terminates */
        if (userMessage.equals("exit")) System.exit(1);

        /* If not exit, send the message to server */
        sender.print(userMessage + "\r\n");
        }