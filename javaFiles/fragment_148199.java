Pattern p = Pattern.compile("Slot Number: (\\d+) Kit Name: (\\S+) Price: (\\d+) Item ID: (\\d+)",
        Pattern.CASE_INSENSITIVE);
String line = "Slot Number: 0 Kit Name: Basic Price: 50 Item ID: 385";
Matcher m = p.matcher(line);
if (m.matches()) {
    int slot = Integer.parseInt(m.group(1));
    String name = m.group(2);
    int price = Integer.parseInt(m.group(3));
    int id = Integer.parseInt(m.group(4));
    System.out.printf("%s %d %d %d%n", name, id, slot, price);
}