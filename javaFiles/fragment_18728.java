private final String RX_FILE = "/sys/class/net/wlan0/statistics/rx_bytes";
private final String TX_FILE = "/sys/class/net/wlan0/statistics/tx_bytes";

    private long readFile(String fileName){
    File file = new File(fileName);
    BufferedReader br = null;
    long bytes = 0;
    try{
        br = new BufferedReader(new FileReader(file));
        String line = "";
        line = br.readLine();
        bytes = Long.parseLong(line);
    }  catch (Exception e){
        e.printStackTrace();
        return 0;

    } finally{
        if (br != null)
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    return bytes;
}