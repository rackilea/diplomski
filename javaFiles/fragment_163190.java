private static InetAddress[] listIPs(String re) throws IOException {
    Pattern pat = Pattern.compile(re);
    try (InputStream stream = new FileInputStream("/etc/hosts");
            Reader reader = new InputStreamReader(stream, "UTF-8");
            BufferedReader in = new BufferedReader(reader)) {
        Set<InetAddress> result = new HashSet<>();
        String line = in.readLine();
        while (line != null) {
            String[] fields = line.split("\\s+");
            boolean found = false;
            for (int i = 1; !found && i < fields.length; ++i) {
                found = pat.matcher(fields[i]).matches();
            }
            if (found) {
                result.add(InetAddress.getByName(fields[0]));
            }
            line = in.readLine();
        }
        return result.toArray(new InetAddress[result.size()]);
    }
}