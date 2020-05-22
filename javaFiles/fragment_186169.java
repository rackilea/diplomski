else if (received.getName().equals("Remove Client!")) {

              Counter.clientsStorage.take();
              System.out.println("Client removed");
              System.out.println("Clients: " + Counter.clientsStorage.size());
              PrintWriter output = new PrintWriter(serverClient.getOutputStream(), true);
              output.println("Student removed");
}