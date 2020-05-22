public class ConnectionHelper {
    /**
     * Returns the working connection type. The connection types can be BIS, BES, TCP, WAP2, TCPIP
     */
    public static HttpConnection getHttpConnection(String url, byte[] postData) {
        int[] preferredOrder = new int[] { CONNECTION_WIFI, CONNECTION_BIS, CONNECTION_BES, CONNECTION_UNITE, CONNECTION_WAP2, CONNECTION_TCPIP, };

        for (int i = 0; i < preferredOrder.length; i++) {
            int type = preferredOrder[i];
            if (isPresent(type)) {
                HttpConnection conn = null;
                OutputStream out = null;
                try {
                    conn = (HttpConnection) Connector.open(convertURL(type, url));
                    if (conn != null) {
                        if (postData == null) {
                            conn.setRequestMethod(HttpConnection.GET);
                            conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");
                        } else {
                            conn.setRequestMethod(HttpConnection.POST);
                            conn.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_LENGTH, String.valueOf(postData.length));
                            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            conn.setRequestProperty("User-Agent", "Profile/MIDP-2.0 Configuration/CLDC-1.0");

                            out = conn.openOutputStream();
                            out.write(postData);
                            out.flush();
                        }
                        if (conn.getResponseCode() != 0) {
                            return conn;
                        }
                    }
                } catch (Exception e) {
                } finally {
                    try {
                        out.close();
                    } catch (Exception e2) {
                    }
                }
            }
        }
        // Only if exception occurs, we close the connection.
        // Otherwise the caller should close the connection himself.
        try {
            conn.close();
        } catch (Exception e1) {
        }

        return null;
    }

    /** Stores transport ServiceBooks if found. Otherwise, null */
    private static ServiceRecord srMDS, srWiFi, srBIS, srWAP2, srUnite;

    private static final int CONNECTION_DEFAULT = 0;
    private static final int CONNECTION_BIS = 1;
    private static final int CONNECTION_BES = 2;
    private static final int CONNECTION_TCPIP = 3;
    private static final int CONNECTION_WIFI = 4;
    private static final int CONNECTION_WAP2 = 5;
    private static final int CONNECTION_UNITE = 6;

    private static final int CONFIG_TYPE_BES = 1;

    private static final String UNITE_NAME = "Unite";

    private static void checkTransportAvailability() {
        initializeTransportAvailability();
    }

    /**
     * Initializes the ServiceRecord instances for each transport (if available). Otherwise leaves it null. Also determines if sufficient coverage is available for each transport
     * and sets coverage* flags.
     */
    private static void initializeTransportAvailability() {
        ServiceBook sb = ServiceBook.getSB();
        ServiceRecord[] records = sb.getRecords();

        for (int i = 0; i < records.length; i++) {
            ServiceRecord myRecord = records[i];
            String cid, uid;

            if (myRecord.isValid() && !myRecord.isDisabled()) {
                cid = myRecord.getCid().toLowerCase();
                uid = myRecord.getUid().toLowerCase();

                // BIS
                if (cid.indexOf("ippp") != -1 && uid.indexOf("gpmds") != -1) {
                    srBIS = myRecord;
                }

                // BES
                if (cid.indexOf("ippp") != -1 && uid.indexOf("gpmds") == -1) {
                    srMDS = myRecord;
                }
                // WiFi
                if (cid.indexOf("wptcp") != -1 && uid.indexOf("wifi") != -1) {
                    srWiFi = myRecord;
                }

                // Wap2.0
                if (cid.indexOf("wptcp") != -1 && uid.indexOf("wifi") == -1 && uid.indexOf("mms") == -1) {
                    srWAP2 = myRecord;
                }

                // Unite
                if (getConfigType(myRecord) == CONFIG_TYPE_BES && myRecord.getName().equals(UNITE_NAME)) {
                    srUnite = myRecord;
                }
            }
        }
    }

    /**
     * Gets the config type of a ServiceRecord using getDataInt below
     * 
     * @param record
     *            A ServiceRecord
     * @return configType of the ServiceRecord
     */
    private static int getConfigType(ServiceRecord record) {
        return getDataInt(record, 12);
    }

    /**
     * Gets the config type of a ServiceRecord. Passing 12 as type returns the configType.
     * 
     * @param record
     *            A ServiceRecord
     * @param type
     *            dataType
     * @return configType
     */
    private static int getDataInt(ServiceRecord record, int type) {
        DataBuffer buffer = null;
        buffer = getDataBuffer(record, type);

        if (buffer != null) {
            try {
                return ConverterUtilities.readInt(buffer);
            } catch (EOFException e) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * Utility Method for getDataInt()
     */
    private static DataBuffer getDataBuffer(ServiceRecord record, int type) {
        byte[] data = record.getApplicationData();
        if (data != null) {
            DataBuffer buffer = new DataBuffer(data, 0, data.length, true);
            try {
                buffer.readByte();
            } catch (EOFException e1) {
                return null;
            }
            if (ConverterUtilities.findType(buffer, type)) {
                return buffer;
            }
        }
        return null;
    }

    private static String convertURL(int connectionType, String url) {
        switch (connectionType) {
        case CONNECTION_BES:
            url += ";deviceside=false";
            break;
        case CONNECTION_BIS:
            url += ";deviceside=false" + ";ConnectionType=mds-public";
            break;
        case CONNECTION_TCPIP:
            url += ";deviceside=true";
            break;
        case CONNECTION_WIFI:
            url += ";interface=wifi";
            break;
        case CONNECTION_WAP2:
            url += ";deviceside=true;ConnectionUID=" + srWAP2.getUid();
            break;
        case CONNECTION_UNITE:
            url += ";deviceside=false;ConnectionUID=" + srUnite.getUid();
            break;
        }

        return url;
    }

    private static boolean isPresent(int connectionType) {
        checkTransportAvailability();

        switch (connectionType) {
        case CONNECTION_BIS:
            return (srBIS != null && CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_BIS_B));

        case CONNECTION_BES:
            return (srMDS != null && CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_MDS));

        case CONNECTION_WIFI:
            return (srWiFi != null && CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_DIRECT, RadioInfo.WAF_WLAN, false));

        case CONNECTION_TCPIP:
            return (CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_DIRECT));

        case CONNECTION_WAP2:
            return (srWAP2 != null && CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_DIRECT));

        case CONNECTION_UNITE:
            return (srUnite != null && CoverageInfo.isCoverageSufficient(CoverageInfo.COVERAGE_MDS));

        case CONNECTION_DEFAULT:
            return true;
        }

        return false;
    }
}