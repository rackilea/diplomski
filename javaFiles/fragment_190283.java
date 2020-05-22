public static void main(String[] args) throws Exception {
    List<List<String>> hm = new ArrayList();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // Change the 3 to any number from 1 - 26
    for (int i = 0; i < 3; i++) {
        List<String> al = new ArrayList();
        for (int j = 0; j <= i; j++) {
            al.add(String.valueOf(alphabet.charAt(j)));
        }
        hm.add(al);
    }
    System.out.println(hm);
}