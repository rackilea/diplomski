@Override
public void run() {
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null) {
            System.out.println(s);
            if(s.equalsIgnoreCase("shutdown")) {
                ThreadPool.isStopped = true;
                break;
            }
        }
    } catch (IOException ex) {
        log.info(new Date() + " Problem in reading Input from keyboard");
    }
    System.out.println("Thread comes out");
    try {
        WebServer.serversocket.close();
    } catch(IOException ie) {
        log.info(new Date() + " Problem in closing socket");
    }
}