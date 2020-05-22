String line, key = null, value = null;
while(scanner.hasNextLine()) {
    line = scanner.nextLine();
    if (line.contains(":")) {
        if (key != null) {
            values.put(key, value.trim());
        }
        int indexOfColon = line.indexOf(":");
        key = line.substring(0, indexOfColon);
        value = line.substring(indexOfColon + 1);
    } else {
        value += " " + line;
    }
}
values.put(key, value.trim());

for (Map.Entry<String, String>  mapEntry: values.entrySet()) {
    System.out.println(mapEntry.getKey() + " -> '" + mapEntry.getValue() + "'");
}