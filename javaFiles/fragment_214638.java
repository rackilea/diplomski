private static class CommandListener implements Runnable {

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                String command = br.readLine();
                if(command.equals("listClients")) {

                    // Assuming you will have static list of customer. In which you will 
                    // add a customer/client when a new client get connected and remove 
                    // when a client get disconnected 

                    System.out.println("Total Connected customer :" + customers.size());
                    System.out.println("Details :");
                    for(Customer cust : customers) {
                        System.out.println(cust.getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}