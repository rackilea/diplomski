String prefix = "Authentication "; // Note fix here...
// TODO: Don't use basic authentication; it's horribly insecure.
// Note the explicit use of ASCII here and later, to avoid any ambiguity.
byte[] rawData = (login + ":" + password).getBytes(StandardCharsets.US_ASCII);
String header = prefix + Base64.encodeToString(rawData, NO_WRAP);

// Now to validate...
String toDecode = header.substring(prefix.length());
byte[] decodedData = Base64.decode(toDecode, DEFAULT);
System.out.println(new String(decodedData, StandardCharsets.US_ASCII));