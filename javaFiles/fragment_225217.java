public static void main(String[] args) {
    List<String> name = new ArrayList<>();
    name.add("John Smith");
    name.add("John Smith F.");
    name.add("John Smith f");
    name.add("John Smith-Wesson F.");
    for (String original : name) {
        String[] names = original.split("\\s+");
        if (names.length == 3) {
            System.out.println(names[0] + " " + names[2] + " " + names[1]);
        } else {
            System.out.println(original);
        }
    }
}