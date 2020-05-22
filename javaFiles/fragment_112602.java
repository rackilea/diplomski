public class PhoneBook {
    public static final int MAX = 10;
    public String name;
    String[] contracts = new String[MAX]; // i created an array of strings
    Contact c;
    private int count = 0;// saved last index of array
    public PhoneBook(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void add(String first, String last, String number) {
        c = new Contact(first, last, number);

        contracts[count] = c.toString(); // save your String inside of last index++
        count++;

    }
    public String first() {
        return get(1);
    }

    public String get(int i) {
        String s = contracts[i].toString();
        return s;
    }

    public String toString() {

    for (int i = 0; i < MAX; i++) {
        if (contracts[i] != null)
            System.out.println(contracts[i].toString()); 
    }
    return "";
}

    public String find(String needle) {

        return null;
    }

}