public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("AB");
        test.add("BC");
        test.add("CD");
        test.add("DE");
        test.add("EF");
        String[] s= new String[10];
        String[] testarray = test.toArray(s); 
        System.out.println(s==testarray);
    }

O/P :

true