br = new BufferedReader(new InputStreamReader(
        new FileInputStream(txtFile)));
String line;
while ((line = br.readLine()) != null) {
    if (line.equals("-")) {
        String ip = null;
        String hostname = null;
        while ((line = br.readLine()) != null) {
            if (line.contains("HOSTNAME: ")) {
                if (line.substring(0, 10).equals("HOSTNAME: ")) {
                    hostname = line.substring(10, line.length());
                }
            }

            if (line.contains("IP: ")) {
                if (line.substring(0, 4).equals("IP: ")) {
                    ip = line.substring(4, line.length());
                }
            }

            if (line.contains("NAME: ")) {
                if (line.substring(0, 6).equals("NAME: ")) {
                    Device device = new Device();
                    device.setIp(ip);
                    device.setHostname(hostname);
                    System.out.println("Adding device with ip = " +
                            ip + " and hostname " + hostname);
                    System.out.println("Details: " + line);
                    devices.add(device);
                }
            }
        }
    }
}