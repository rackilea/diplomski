public class Utils {


public static String getStringFromRaw(Context mContext, int resource) throws IOException {
    Resources r = mContext.getResources();
    InputStream is = r.openRawResource(resource);
    String statesText = convertStreamToString(is);
    is.close();
    return statesText;
}

private static String convertStreamToString(InputStream is) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = is.read();
    while (i != -1) {
        byteArrayOutputStream.write(i);
        i = is.read();
    }
    return byteArrayOutputStream.toString();
}
}