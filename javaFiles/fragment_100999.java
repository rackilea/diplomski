List<String> mixedup = Arrays.asList("A", "0", "B", "C", "1", "D", "F", "3");
List<String> numbersOnlyList = new ArrayList<>();
for (String s : mixedup) {
    try {
        // here you could evaluate you property or field
        Integer.valueOf(s);
        numbersOnlyList.add(s);
    } catch (NumberFormatException ignored) {
    }
}
System.out.println("Results of the iterated List: " + numbersOnlyList);