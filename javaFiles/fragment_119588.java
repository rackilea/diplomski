class Junk {

    private class Transaction {
        private final String name;
        private final int id;

        public Transaction(int id){
            this.id = id;
            this.name= "T"+id;
        }

        public String getName(){
            return this.name;
        }

        public int getId(){
            return this.id;
        }

        public String toString(){
            return "Name: "+ name+"\nID: "+id+"\n";
        }
    }

    private ArrayList<Transaction> transactions;
    private int curr_id = 0;
    private String name;

    public synchronized String NewTransaction() {
        curr_id++;
        Transaction transaction = new Transaction(curr_id);
        return transaction.toString();
    }
}