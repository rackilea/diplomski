public class DeviceHelper {

private static String sID = null;
private static final String INSTALLATION = "INSTALLATION";

public synchronized static String getDeviceId(final Context context) {
    if (sID == null) {
        File installation = new File(context.getFilesDir(), INSTALLATION);
        try {
            if (!installation.exists()){
                writeInstallationFile(context,installation);
            }
            sID = readInstallationFile(installation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    return sID;
}

private static String readInstallationFile(File installation) throws IOException {
    RandomAccessFile f = new RandomAccessFile(installation, "r");
    byte[] bytes = new byte[(int) f.length()];
    f.readFully(bytes);
    f.close();
    return new String(bytes);
}

private static void writeInstallationFile(final Context context,File installation) throws IOException {
    FileOutputStream out = new FileOutputStream(installation);
    StringBuffer buf=new StringBuffer();
    buf.append(Settings.Secure.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID));
    buf.append("-");
    buf.append(UUID.randomUUID().toString());
    out.write(buf.toString().getBytes());
    out.close();
}

}