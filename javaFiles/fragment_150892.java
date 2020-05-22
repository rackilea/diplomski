public static long ipToLong(String ip) {
        String[] addrArray = ip.split("\\.");

        long ipDecimal = 0;

        for (int i = 0; i < addrArray.length; i++) {

            int power = 3 - i;
            ipDecimal += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));
        }
        return ipDecimal;
    }