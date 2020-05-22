String[] names = new String[]{
        "25 Jackson 11,693 Nevaeh 6,345",
        "26 Jackson 44,444 Nevaeh 3,56"
};
String[][] words = new String[names.length][5];

for (int i = 0; i < names.length; i++) {
    words[i] = names[i].split("\\s+");
}

Arrays.stream(words).map(Arrays::toString).forEach(System.out::println);