String jws = Jwts.builder()
        .claim("rainId", rainId.toString())
        .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode("jwtSecretKey"))
        .compact();

Jws<Claims> jwsClaims = Jwts.parser()
        .require("rainId",rainId.toString())
        .setSigningKey(TextCodec.BASE64.encode("jwtSecretKey1"))
        .parseClaimsJws(jws);