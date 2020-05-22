public static void main(String[] args) throws Exception {

    URL whatismyip = new URL("http://automation.whatismyip.com/n09230945.asp");
    URLConnection connection = whatismyip.openConnection();
    connection.addRequestProperty("Protocol", "Http/1.1");
    connection.addRequestProperty("Connection", "keep-alive");
    connection.addRequestProperty("Keep-Alive", "1000");
    connection.addRequestProperty("User-Agent", "Web-Agent");

    BufferedReader in = 
        new BufferedReader(new InputStreamReader(connection.getInputStream()));

    String ip = in.readLine(); //you get the IP as a String
    System.out.println(ip);
}