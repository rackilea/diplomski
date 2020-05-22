import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.ws.rs.core.HttpHeaders;

// …
    builder.header(HttpHeaders.AUTHORIZATION, calculateAuthentication(username, password));
// …

private String calculateAuthentication(final String username, final byte[] password) {
    final byte[] prefix = (username + ":").getBytes(StandardCharsets.UTF_8);
    final byte[] usernamePassword = new byte[prefix.length + password.length];
    System.arraycopy(prefix, 0, usernamePassword, 0, prefix.length);
    System.arraycopy(password, 0, usernamePassword, prefix.length, password.length);
    return "Basic " + Base64.getEncoder().encodeToString(usernamePassword);
}