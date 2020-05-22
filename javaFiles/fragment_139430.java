public class IntCount {

    public static void main(String[] args) {
        count("123 234 456 678 789 234 234 123");

    }

    public static void count(String transactionLine) {
        String[] parts = transactionLine.split(" ");

        Map<String, Integer> hashTable = new HashMap<String, Integer>();
        // Count duplicates
        for (String s : parts) {
            if (hashTable.get(s) == null) hashTable.put(s, 1);
            else hashTable.put(s, hashTable.get(s) + 1);
        }

        for (String s : hashTable.keySet()) {
            System.out.println("s: " + s + " count: " + hashTable.get(s));
        }
    }
}