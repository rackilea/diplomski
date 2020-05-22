private class NTLM {
    /** Character encoding */
    public static final String DEFAULT_CHARSET = "ASCII";

    /**
    * The character was used by 3.x's NTLM to encode the username and
    * password. Apparently, this is not needed in when passing username,
    * password from NTCredentials to the JCIFS library
    */
    private String credentialCharset = DEFAULT_CHARSET;

    void setCredentialCharset(String credentialCharset) {
           this.credentialCharset = credentialCharset;
    }

    private static final int TYPE_1_FLAGS = NtlmFlags.NTLMSSP_NEGOTIATE_NTLM
                 | NtlmFlags.NTLMSSP_NEGOTIATE_UNICODE
                 | NtlmFlags.NTLMSSP_NEGOTIATE_NTLM2;

    private String generateType1Msg(String host, String domain) {
           jcifs.ntlmssp.Type1Message t1m = new jcifs.ntlmssp.Type1Message(
                        TYPE_1_FLAGS, domain, host);
           return jcifs.util.Base64.encode(t1m.toByteArray());
    }

    private String generateType3Msg(String username, String password,
                 String host, String domain, String challenge) {
           jcifs.ntlmssp.Type2Message t2m;
           try {
                 t2m = new jcifs.ntlmssp.Type2Message(
                               jcifs.util.Base64.decode(challenge));
           } catch (IOException e) {
                 throw new RuntimeException("Invalid Type2 message", e);
           }

           final int type2Flags = t2m.getFlags();
           final int type3Flags = type2Flags
                        & (0xffffffff ^ (NtlmFlags.NTLMSSP_TARGET_TYPE_DOMAIN | NtlmFlags.NTLMSSP_TARGET_TYPE_SERVER));

           jcifs.ntlmssp.Type3Message t3m = new jcifs.ntlmssp.Type3Message(
                        t2m, password, domain, username, host, type3Flags);
           return jcifs.util.Base64.encode(t3m.toByteArray());
    }
}