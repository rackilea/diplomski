byte[] n = rsapubkey.getModulus().toByteArray(); // Java is 2sC bigendian
byte[] e = rsapubkey.getPublicExponent().toByteArray(); // and so is SSH
byte[] tag = "ssh-rsa".getBytes(); // charset very rarely matters here
ByteArrayOutputStream os = new ByteArrayOutputStream();
DataOutputStream do = new DataOutputStream(os);
do.writeInt(tag.length); do.write(tag);
do.writeInt(e.length); do.write(e);
do.writeInt(n.length); do.write(n);
byte[] encoded = os.toByteArray();
// now hash that (you don't really need Apache) 
// assuming SHA256-base64 (see below)
MessageDigest digest = MessageDigest.getInstance("SHA256");
byte[] result = digest.digest(encoded);
String output = Base64.getEncoder().encodeToString(result);