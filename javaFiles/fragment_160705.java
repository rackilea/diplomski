new Thread(new Runnable() {
    public void run() {
        ServerAccessMobile serverAccessMobile = new ServerAccessMobile(); 

    ArrayList <String> dataFromServer = **serverAccessMobile.getDataFromServer()**;

    ArrayList <String> dataToSend = .....

    serverAccessMobile.setDataOServer(dataToSend);
    }
}).start();