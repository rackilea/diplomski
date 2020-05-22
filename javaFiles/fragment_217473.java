String homeDir = System.getProperty("java.home");
try {
    String dataFile = homeDir + File.separator +
            "lib" + File.separator + "currency.data";
    DataInputStream dis = new DataInputStream(
        new BufferedInputStream(
        new FileInputStream(dataFile)));
    if (dis.readInt() != MAGIC_NUMBER) {
        throw new InternalError("Currency data is possibly corrupted");
    }
    formatVersion = dis.readInt();
    if (formatVersion != VALID_FORMAT_VERSION) {
        throw new InternalError("Currency data format is incorrect");
    }
    dataVersion = dis.readInt();
    mainTable = readIntArray(dis, A_TO_Z * A_TO_Z);
    int scCount = dis.readInt();
    scCutOverTimes = readLongArray(dis, scCount);