while (bConnected) {

    String str = dis.readUTF();                   // Reads from `dis`
    System.out.println(str);

    for (int i = 0; i < clients.size(); i++) {

         Client c = clients.get(i);
         c.send(str);                             // uses data read above, doesn't touch `dis`
    }
}