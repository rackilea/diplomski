List<String[]> result = new ArrayList<>();
String[] arr = {"a", "b", "c", "d", "e"};
for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        result.add(new String[]{arr[i], arr[j]});
    }
}