if (device.getAPWifiInfo() != null) {
                String mac = device.getAPWifiInfo().getSSID();
                String split_mac[] = mac.split(" ");
                Log.i(TAG, "Mac from ssid is " + split_mac[1]);
                mac = split_mac[1];
                ip = getIPfromMac(mac);
                Log.i(TAG, "IP is " + ip);
}



   //returns the ip and takes mac address as parameter

   public static String getIPfromMac(String mac) {
        if (mac == null)
            return null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/proc/net/arp"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(" +");
                if (splitted != null && splitted.length >= 4 && mac.equalsIgnoreCase(splitted[3])) {
                    // Basic sanity check
                    String ip = splitted[0];
                    return ip;
                }

            }
            return null;
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