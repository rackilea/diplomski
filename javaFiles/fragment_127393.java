class NestedGenerics {
    private static final Map<String, Map<String, ? extends Command>> DIRECTORY = new HashMap<>();

    public static void main(String[] args) {
        Map<String, Command<Integer>> integerMap = new HashMap<>();
        Map<String, Command<Double>> doubleMap = new HashMap<>();

        integerMap.put("integer_command", new Command<Integer>() {
            @Override
            public void run(Integer number, String field) {
                System.out.println(field + ": " + number);
            }
        });
        doubleMap.put("double_command", new Command<Double>() {
            @Override
            public void run(Double number, String field) {
                System.out.println(field + ": " + number);
            }
        });

        DIRECTORY.put("integers", integerMap);
        DIRECTORY.put("doubles", doubleMap);

        DIRECTORY.get("integers").get("integer_command").run(Integer.valueOf(42), "integer field");
        DIRECTORY.get("doubles").get("double_command").run(Double.valueOf(42.0), "double field");
    }
}