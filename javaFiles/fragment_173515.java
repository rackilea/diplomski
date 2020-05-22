String TIME_SERVER = "time-a.nist.gov";   
TimeTCPClient client = new TimeTCPClient();

try {
    client.connect(TIME_SERVER);
    System.out.println(client.getDate());
} finally {
    client.disconnect();
}