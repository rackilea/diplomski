byte[] privateKeyBytes = privateKeyPEM.getBytes();
// privateKeyBytes now contains the base64 encoded key data

String encodedString = Base64.getEncoder().encodeToString(privateKeyBytes);
// encoded String contains now the base64 encoded data of the base64 encoded key data

byte[] decodedString = Base64.getDecoder().decode(encodedString);
// decodedString is not the base64 encoded data of your key data