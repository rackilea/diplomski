public static void main(String[] args) {
    List<String> data = new ArrayList<String>();
    String yourRequiredString = "dessert";
    data.add("apple fruit");
    data.add("carrot vegetable");
    data.add("cake dessert");
    for (int i = 0; i < data.size(); i++) {
        if (data.get(i).contains(yourRequiredString)) {
            System.out.println(i);
        }
    }
}