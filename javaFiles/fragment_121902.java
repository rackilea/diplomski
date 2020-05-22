StringBuilder pkcs8Lines = new StringBuilder();
        BufferedReader rdr = new BufferedReader(new StringReader(SECRET_KEY2));
        String line;
        while ((line = rdr.readLine()) != null) {
            pkcs8Lines.append(line);
        }
        String pkcs8Pem = pkcs8Lines.toString();
        pkcs8Pem = pkcs8Pem.replace("-----BEGIN PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replace("-----END PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replaceAll("\\s+","");

        byte[] valueDecoded = Base64.decodeBase64(pkcs8Pem);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(valueDecoded);
        KeyFactory rsaFact = KeyFactory.getInstance("RSA");
        RSAPrivateKey key = (RSAPrivateKey) rsaFact.generatePrivate(keySpec);

        JwtBuilder builder = Jwts.builder().setId("ID")
                .setIssuedAt(new Date())
                .setSubject("Subject")
                .setIssuer("Issuer")
                .signWith(SignatureAlgorithm.RS256, key);
        return builder.compact();