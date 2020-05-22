import org.apache.commons.net.util.Base64;
...
jnlpURL  = deBase64(System.getProperty("jnlp.url"));
...
private String deBase64(String str)
{
    if (Base64.isArrayByteBase64(str.getBytes())) {
        return new String(Base64.decodeBase64(str));
    } else {
        return str;
    }
}