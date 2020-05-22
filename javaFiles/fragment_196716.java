public void test() {
    ArrayDeque<String> ad = new ArrayDeque<>();
    ad.add("Hello");
    ad.add("Bye!");
    ArrayList<String> al = new ArrayList<>(ad);
    List<String> alp = al.subList(1, al.size());
    System.out.println("ad=" + ad);
    System.out.println("al=" + al);
    System.out.println("alp=" + alp);
}