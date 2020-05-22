public void sendMessage(String message) {
    for (String ch : message.split(""))
        sendPacket(ch);
    sendPacket("\r\n");
}

public void sendPacket(String payload) {
    if (out != null && !out.checkError()) {
        out.print(payload);
        out.flush();
        Log.i("Terminal", "Message sent.");
    }
}