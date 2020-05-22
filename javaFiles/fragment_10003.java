private static DataOutputStream out;

out = new DataOutputStream(clientSocket.getOutputStream());

public static void sendType(String type) {
    out.writeUTF(type);
    out.flush();
}