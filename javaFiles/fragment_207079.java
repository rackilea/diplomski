class LinkedHashSet {

    public static void main(String[] args) {
        //LinkedHashSet<String> lHs = new LinkedHashSet<String>();
        LinkedHashSet lHs = new LinkedHashSet();

        lHs.add("Beta");
        lHs.add("Alpha");
        lHs.add("Eta");
        lHs.add("Gamma");
        lHs.add("Epsilon");
        lHs.add("Omega");

        System.out.println(lHs);
    }
}