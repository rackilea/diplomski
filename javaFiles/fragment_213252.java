public static void main(String[] args) {
    ArrayList<String> y = new ArrayList<>();
    y.add("Go");
    y.add("Home");
    y.add("Go");
    y.add("Home");
    System.out.println(y);
    System.out.println("Occurence of 'Go' is " + countOccurence("Go", y));
}

public static int countOccurence(String y, ArrayList<String> t) {
    int count = 0;
    for (int i = 0; i < t.size(); i++) {
        if (y.equalsIgnoreCase(t.get(i))) {
            count++;
        }
    }
    return count;
}