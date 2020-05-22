String line;
while ((line = reader.readLine()) != null) {
    String[] parts = line.split(" ");
    if (parts.length != 3) {
        continue;
    }
    list1.add(Integer.parseInt(parts[0]));
    list2.add(Double.parseDouble(parts[1]));
    list3.add(Double.parseDouble(parts[2]));
}