// function to affect
public static void addMsg() {
    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    String msg1 = inputOutput(br, "Enter message 1");
    String msg2 = inputOutput(br, "Enter message 2");
    System.out.println(msg1 + " " + msg2);
}
// basically a scanner
private static String inputOutput(BufferedReader br, String message) {
    System.out.println(message);
    String returnString = "";
    try {
        returnString = br.readLine();
    } catch (IOException e) {
        System.out.println("Error reading in value");
    }
    return returnString;
}