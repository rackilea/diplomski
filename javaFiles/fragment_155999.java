public class Test {

    public static void main(final String[] args) throws Exception {
        final Transaction transaction = new Transaction();

        transaction.add("some name");
        transaction.add("another name");
        transaction.add("yet another name");

        System.out.println(transaction.containsName("some name"));
        System.out.println(transaction.containsName("non-existent name"));
    }

}