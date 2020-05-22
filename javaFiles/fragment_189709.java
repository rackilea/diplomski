public static void main(String[] args) {
    String s = "";
    ArrayList<String> avoid = new ArrayList<String>();

    System.out.println("Avoid:");
    Scanner sc2 = new Scanner(System.in);
    Boolean flag = true;
    s = sc2.nextLine();
    String[] words = s.split("\\s+");
    for (int i = 0; i < words.length; i++) {
        avoid.add(words[i]);
    }
    System.out.println("done");
    for (int i = 0; i < avoid.size(); i++) {
        System.out.println(avoid.get(i));
    }

}