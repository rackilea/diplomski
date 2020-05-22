public class Strings {
    public enum Message { HELLO, WORLD, HELLOWORLD, HELLOAGAIN };

    public static void main(String[] args) {
        List<Message> shuffled = Arrays.asList(Message.values());
        Collections.shuffle(shuffled);
        for (Message msg : shuffled) {
            System.out.println(msg);
        }
    }
}