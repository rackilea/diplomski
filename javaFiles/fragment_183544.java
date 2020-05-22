private static void output() {

    String[] str_array = {"Beth", "Jerry", "Rick", "Summer", "Morty"};
    List<String> list = new ArrayList<>(Arrays.asList(str_array));
    list.remove("Rick");
    str_array = list.toArray(new String[0]);

    for (String x : str_array) {
        System.out.println(x);
    }
}