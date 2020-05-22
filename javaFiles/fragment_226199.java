Iterator<String> lineIterator = Files.lines(Paths.get(fileName)).iterator();

while (lineIterator.hasNext()) {
    String line = lineIterator.next();
    if (line.startsWith(".end")) {
        // Abort parsing the file
        break;
    }

    // Valid line, parse it
    Device d = new Device();
    d.parseDeviceData(line);
    devices.add(d);
}