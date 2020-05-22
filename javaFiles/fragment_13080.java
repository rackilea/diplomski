public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Define true and false values
    Map<String, Boolean> truthiness = new HashMap<>();

    truthiness.put("yes", true);
    truthiness.put("1", true);
    truthiness.put("true", true);
    truthiness.put("t", true);
    truthiness.put("ya", true);
    truthiness.put("nein", false);
    //etc

    // Define only the true values
    List<String> trueValues = Arrays.asList("yes", "1", "true", "t", "ya");

    for(int i = 0; i < 5; ++i) {
        String value = sc.nextLine().toLowerCase();

        System.out.println("map: " + truthiness.get(value));
        System.out.println("list: " + trueValues.contains(value));
    }
}