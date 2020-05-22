class StringLengthComparator implements Comparator<Name> {
    public int compare(Name n1, Name n2) {
        return n1.getLength()-n2.getLength();
    }
}

class StringCommonComparator implements Comparator<Name> {
    public int compare(Name n1, Name n2) {
        return n1.getName().compareTo(n2.getName());
    }
}

public class Name {
    private String name;

    public Name(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.name.length();
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Name> N = new ArrayList<>(5);
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please Enter Name: ");
        String n = keyIn.readLine();
        N.add(new Name(n));

        for(int i=0; i<5; i++) {
            String name = keyIn.readLine();
            N.add(new Name(name));
        }

        System.out.println();
        System.out.println("Compare by Length");
        N.sort(new StringLengthComparator());

        for(int i=0;i<N.size();i++) {
            System.out.println(N.get(i).name);
        }

        System.out.println();
        System.out.println("Compare by String");
        N.sort(new StringCommonComparator());

        for(int i=0;i<N.size();i++) {
            System.out.println(N.get(i).name);
        }
    }
}