Scanner s = new Scanner(new File("Files/Destination.txt"));
int currentCount = 0;
String currentZone = "";
while(s.hasNextLine()) {
    String line = s.nextLine();
    if (line.startsWith("#") { // number of countries
        currentCount = Integer.parseInt(line.substring(1));
    } else if (line.length() == 1) { // zone
        currentZone = line;
        destinations.put(currentZone, new ArrayList<String>(currentCount);
    } else { // add country to current zone
        destinations.get(currentZone).add(line);
    }
}