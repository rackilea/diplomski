class ClientThread {
    ...
    public void run() {
        ....
        while ((inputLine = in.readLine()) != null) {
            // process client message
        }
        in.close();
    }
}