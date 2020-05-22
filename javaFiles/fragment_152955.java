String plainCreds = "yourUsername@yourPassword";
byte[] plainCredsBytes = plainCreds.getBytes();
byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
String base64Creds = new String(base64CredsBytes);
HttpHeaders headers = new HttpHeaders();
headers.add("Authorization", "Basic " + base64Creds);