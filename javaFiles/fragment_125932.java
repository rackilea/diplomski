public class engToEnc {

    public String Message;
    public char[] c;

    public String readMessage(String pMessage) {

        this.Message = pMessage;
        c = new char[Message.length()];

        for (int i = 0; i < Message.length(); i++) {
            c[i] = Message.charAt(i);
            c[i] += (char) 27;
        }

        Message = String.copyValueOf(c);

        return Message;
    }

}