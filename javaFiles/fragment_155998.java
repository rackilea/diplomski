public class Test {

    public static void main(final String[] args) {
        final List<TransactionLine> transaction = new ArrayList<>();

        transaction.add(new TransactionLine(1, "some value"));
        transaction.add(new TransactionLine(2, "another value"));
        transaction.add(new TransactionLine(3, "yet another value"));

        System.out.println(containsName(transaction, "some value"));
        System.out.println(containsName(transaction, "non-existent value"));
    }

    // Iterates over all transactions until a transaction is found that has the
    // same name as specified in search
    private static boolean containsName(final List<TransactionLine> transaction, final String search) {
        for (final TransactionLine transactionLine : transaction) {
            if (transactionLine.getName().equals(search)) {
                return true;
            }
        }

        return false;
    }

    private static class TransactionLine {

        private int id;

        private String name;

        public TransactionLine(final int id, final String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

    }

}