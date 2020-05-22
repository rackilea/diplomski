public enum DatacenterEnum {
    DEV, DC1, DC2, DC3;


    public static DatacenterEnum getOurlocation() {
        return ourlocation;
    }

    private static final Random random = new Random();

    public static String forCode(int code) {
        return (code >= 0 && code < values().length) ? values()[code].name() : null;
    }

    private static final DatacenterEnum ourlocation = compareLocation();

    private static DatacenterEnum compareLocation() {
        String currenthost = getHostNameOfServer();

        if (currenthost != null) {
            if (isDevMachine(currenthost)) {
                return DC1;
            }

            for (DatacenterEnum dc : values()) {
                String namepart = "." + dc.name().toLowerCase() + ".";
                if (currenthost.indexOf(namepart) >= 0) {
                    return dc;
                }
            }
        }
        return null;
    }

    enum Flow {
        USERFLOW , DEVICEFLOW 
    }
    public String toLocalPook(Flow f) {
        String prefix = "";
        if (f.equals(Flow.DEVICEFLOW)) {
            prefix = "/testdevice";
        } else if (f.equals(Flow.USERFLOW)) {
            prefix = "/test";
        }
        if (this == DEV) {
            return prefix + "/datacenter/dc1";
        }

        return prefix + "/datacenter/" + name().toLowerCase();
    }


    private static final String getHostNameOfServer() {
        try {
            return InetAddress.getLocalHost().getCanonicalHostName().toLowerCase();
        } catch (UnknownHostException e) {
            // log an exception
        }

        return null;
    }

    private static boolean isDevMachine(String hostName) {
        return hostName.indexOf("." + DEV.name().toLowerCase() + ".") >= 0;
    }

}