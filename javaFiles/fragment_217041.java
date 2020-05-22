List<String> coinNames = new ArrayList<>();
String line; 
int x = 0;
while ((line = reader.readLine()) != null) {
    coinNames.add(line);
    x++;
}

for (String name : coinNames) {
    System.out.println(name);
}