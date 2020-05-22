Scanner sc = new Scanner(new File("A.txt"));
List<String> lines = new ArrayList<String>();
while (sc.hasNextLine()) {
   lines.add(sc.nextLine());
}

String[] numbers = new String[lines.size()];
String[] characters = new String[lines.size()];
for (int i = 0; i < lines.size(); i++) {
    String[] components = lines.get(i).split(" ");
    numbers[i] = components[0];
    characters[i] = components[1];
}