String password = "secret123";
MessageDigest digest = MessageDigest.getInstance("SHA-256");
Charset scs = StandardCharsets.UTF_8;
byte[] encodedhash = digest.digest(password.getBytes(scs));
String hash = toHexString(encodedhash);
String bcrypt = BCrypt.hashpw(hash, BCrypt.gensalt());