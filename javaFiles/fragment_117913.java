Connection conn = new Connection(remoteHostNameOrIP);
try {
    conn.connect();

} catch (Exception e) {

    System.out.println("Message is : -" + e.getMessage());
    return "unable to connect";
}