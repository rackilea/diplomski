Scanner s = new Scanner(input)
    .useDelimiter("[^A-Za-z]+");
List<String> parts = new ArrayList<>();
while (s.hasNext()) {
    parts.add(s.next());
}