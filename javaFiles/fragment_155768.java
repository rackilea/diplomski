public static void main(String[] args) {
        TreeSet<String> a = new TreeSet<String>();
        a.add("2001V001.10");
        a.add("2001V002.10");
        a.add("2002V001.10");
        a.add("2003V001.10");
        a.add("2004V001.10");
        a.add("2004V001.20");
        for (String string : a) {
            System.out.println(string);
        }

}