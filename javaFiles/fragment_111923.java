boolean found = false;
while ((!found) && ((line = reader.readLine()) != null)) {
 if (found = line.contains("blabla")) {
  line = line.replaceAll("blabla", "eee");
 }
 writer.write(line);
}