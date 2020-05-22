protected String getMacAddress(String ipAddress) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(new File("/proc/net/arp")));
        String line;
        while((line = br.readLine()) != null) {
            if(line.contains(ipAddress)) {
                /* this string still would need to be sanitized */
                return line;
            }
        }
        System.out.println(output);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}