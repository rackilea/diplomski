public void Ll() {
    Map<String, String> map = new HashMap<>();
    map.put("Ł", "L");
    map.put("ł", "l");

    System.out.println(Arrays.stream("ŁałaŁała".split("(?!^)"))
            .map(c -> {
                String letter = map.get(c);
                return letter == null ? c : letter;
            })
            .collect(Collectors.joining("")));
}