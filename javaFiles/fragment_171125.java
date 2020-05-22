String [] a = {"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", 
    "Bart9", "Bart10", "Lisa", "Marge", "Homer", "Bart", 
    "Bart1", "Bart2", "Bart3", "Bart11", "Bart12"};

java.util.Arrays.sort(a, new Comparator<String>() {

    final String regex = "^([\\D]+)([0-9]+)$";
    Pattern p = Pattern.compile(regex);
    Matcher m1, m2;

    @Override
    public int compare(String o1, String o2) {
        m1 = p.matcher(o1);
        m2 = p.matcher(o2);

        if (m1.matches() && m2.matches()) {
            if (m1.group(1).equals(m2.group(1))) 
                return Integer.valueOf(m1.group(2)).compareTo(Integer.valueOf(m2.group(2)));
        } 

        return o1.compareTo(o2);
    }
});

for (String s : a) System.out.println(s);