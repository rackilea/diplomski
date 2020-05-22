public DataOutputStream connection(){
    DataOutputStream out = null;
    try {
        Socket cs = new Socket("192.168.1.100", 8002);
        out = new DataOutputStream(cs.getOutputStream());
        if(cs.isConnected())
            Toast.makeText(MainActivity.this, "Connected to Server", Toast.LENGTH_LONG).show();

    } catch (UnknownHostException er) {
        Toast.makeText(MainActivity.this, er.getMessage(), Toast.LENGTH_LONG).show();
    } catch (IOException er) {
        Toast.makeText(MainActivity.this, er.getMessage(), Toast.LENGTH_LONG).show();
    }
    return out;
}