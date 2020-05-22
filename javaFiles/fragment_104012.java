/**
 * Try to extract a hardware MAC address from a given IP address using the
 * ARP cache (/proc/net/arp).<br>
 * <br>
 * We assume that the file has this structure:<br>
 * <br>
 * IP address       HW type     Flags       HW address            Mask     Device
 * 192.168.18.11    0x1         0x2         00:04:20:06:55:1a     *        eth0
 * 192.168.18.36    0x1         0x2         00:22:43:ab:2a:5b     *        eth0
 *
 * @param ip
 * @return the MAC from the ARP cache
 */
public static String getMacFromArpCache(String ip) {
    if (ip == null)
        return null;
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader("/proc/net/arp"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitted = line.split(" +");
            if (splitted != null && splitted.length >= 4 && ip.equals(splitted[0])) {
                // Basic sanity check
                String mac = splitted[3];
                if (mac.matches("..:..:..:..:..:..")) {
                    return mac;
                } else {
                    return null;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return null;
}