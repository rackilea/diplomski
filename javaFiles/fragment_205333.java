private String doGenerateToken(Map<String, Object> claims, String subject) {

String encodedString = Base64.getEncoder().encodeToString(secret.getBytes())
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, encodedString ).compact();
    }