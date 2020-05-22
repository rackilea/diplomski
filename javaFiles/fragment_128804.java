import jcifs.smb.NtlmPasswordAuthentication;

/**
 * NTLM passwords encoding.
 * 
 * This implementation depends on the JCIFS library.
 */
public class NTLMPassword {

    private final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private NTLMPassword() {
        throw new UnsupportedOperationException("Can not instantiate this class.");
    }

    /**
     * Return NTLM hash for a given string.
     * 
     * See https://lists.samba.org/archive/jcifs/2015-February/010258.html
     * 
     * @param value
     *            the string to hash.
     * @return the NTLM hash for the given string.
     */
    public static String encode(String value) {
        String s = (value != null) ? value : "";
        byte[] hash = NtlmPasswordAuthentication.nTOWFv1(s);
        return bytesToHex(hash).toUpperCase();
    }

    /**
     * See https://stackoverflow.com/a/9855338/1314986
     */
    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}