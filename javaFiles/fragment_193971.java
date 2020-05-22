public static void main(String[] args) {
    ArrayList<String> houses = new ArrayList<>(25);
    houses.add("(1x1)");
    houses.add("(1x2)");
    houses.add("(1x1)");
    houses.add("(1x3)");
    houses.add("(1x1)");
    houses.add("(1x4)");
    houses.add("(1x1)");
    houses.add("(1x5)");

    System.out.println(houses.size());
    System.out.println(duplicateHouses2(houses));
}

public static int duplicateHouses(ArrayList<String> houses) {
    int duplicateCount = 0;

    for (int i = 0; i < houses.size(); i++) {
        System.out.println("---");
        for (int j = i + 1; j < houses.size(); j++) {
            if ((houses.get(i)).equals(houses.get(j))) {
                System.out.println(i + ": " + houses.get(i) + " == " + j + ": " + houses.get(j));
                duplicateCount++;
            }
        }
    }

    return duplicateCount;
}