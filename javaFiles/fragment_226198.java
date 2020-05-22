BufferedReader in;
in = new BufferedReader(new FileReader(fileName));

while (true) {
    String line = in.readLine();
    if (line == null || line.startsWith(".end")) {
        // Abort parsing the file
        break;
    }

    // Valid line, parse it
    Device d = new Device();
    d.parseDeviceData(line);
    devices.add(d);
}