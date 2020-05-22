// Wrap original response with it:
MD5ServletResponse md5response = new MD5ServletResponse(response);

// Now just use md5response instead or response, e.g.:
dispatcher.handle(request, md5response);

// Then get the hash, e.g.:
byte[] hash = md5response.getHash();
StringBuilder hashAsHexString = new StringBuilder(hash.length * 2);
for (byte b : hash) {
    hashAsHexString.append(String.format("%02x", b));
}
System.out.println(hashAsHexString); // Example af28cb895a479397f12083d1419d34e7.