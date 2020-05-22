while (bConnected == true) { /* Note the use of `=` instead of `==` in your question */

    System.out.println(dis.readUTF().toString());           // Reads from the input stream 

    for (int i = 0; i < clients.size(); i++) {

        Client c = clients.get(i);
        c.send(dis.readUTF().toString());                   // Reads from the input stream
    }
}