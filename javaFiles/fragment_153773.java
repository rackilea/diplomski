public static boolean isEncodeableInGsm0338(String isoString) {
        byte[] isoBytes = isoString.getBytes();
        outer:
        for (int i = 0; i < isoBytes.length; i++) {
            for (int j = 0; j < isoGsm0338Array.length; j++) {
                if (isoGsm0338Array[j] == isoBytes[i]) {
                    continue outer;
                }
            }
            for (int j = 0; j < extendedIsoGsm0338Array.length; j++) {
                if (extendedIsoGsm0338Array[j][1] == isoBytes[i]) {
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }