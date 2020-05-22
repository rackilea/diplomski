while (true) {
    CustomerClient cusClient = new CustomerClient("B", server_IP_1,
        server_Port_1, server_IP_2, server_Port_2);
    System.out.println("new thread A");
    cusClient.start();
    cusClient.join();
}