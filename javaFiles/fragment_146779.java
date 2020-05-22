public static void main(String[] args) {
    ArrayList<String> labels = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
        labels.add("x" + i);
    }
    System.out.println(String.join(", ", labels));
}