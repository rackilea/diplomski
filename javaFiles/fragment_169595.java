String json = Files.lines(Paths.get("src/main/resources/test.json")).collect(Collectors.joining());
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

// here is the parsing of PublicKey
ApplePublicKeyResponse applePublicKeyResponse = objectMapper.readValue(json, ApplePublicKeyResponse.class);

Key key = applePublicKeyResponse.getKeys().get(0);

byte[] nBytes = Base64.getUrlDecoder().decode(key.getN());
byte[] eBytes = Base64.getUrlDecoder().decode(key.getE());

BigInteger n = new BigInteger(1, nBytes);
BigInteger e = new BigInteger(1, eBytes);

RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(n,e);
KeyFactory keyFactory = KeyFactory.getInstance(key.getKty()); //kty will be "RSA"
PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);