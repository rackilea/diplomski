class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1: First", "2: Second", "3: Third", "4: Fourth");
        List<String> resultList = stringList.stream()
                .sorted()
                .filter(new Predicate<String>() {
                    private String prev = null;

                    @Override
                    public boolean test(String s) {
                        boolean result = s.contains("Second") && prev != null && prev.contains("First");
                        prev = s;
                        return result;
                    }
                })
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}