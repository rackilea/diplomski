public static void main(String[] args) throws IOException, PhoneNumberNotAvailableException, InterruptedException {
    System.setProperty("kvem.home", "/home/jassuncao/usr/WTK2.5.2");
    WMAClient wmaClient = WMAClientFactory.newWMAClient(null, 4);
    wmaClient.connect();       
    wmaClient.setMessageListener(new MessageListener() {
        @Override
        public void notifyIncomingMessage(WMAClient wmaclient) {
            try {
                System.out.println("Message received:"+wmaclient.receive());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    System.out.println("This number "+wmaClient.getPhoneNumber());        
    String[] receivers = wmaClient.getKnownReceivers();        
    for (String receiver : receivers) {
        System.out.println("Sending SMS to "+receiver);         
        Message msg = new Message("Hello world!!");         
        msg.setFromAddress("sms://"+wmaClient.getPhoneNumber());
        msg.setToAddress("sms://"+receiver);
        //It seems the ports must be set AFTER the address to work
        msg.setToPort(50000);
        msg.setFromPort(50000);
        wmaClient.send(msg);    
    }   
    System.in.read();       
    wmaClient.unregisterFromServer();       
}