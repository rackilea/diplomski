JSONObject datiClaim = new JSONObject();
datiClaim.put("id", -1);
datiClaim.put("id_contratto", 1);

...

JwtBuilder MY_JwtBuilder = Jwts.builder()
            .setIssuedAt( new Date() )
            .setIssuer("Fausto")
            .setSubject("Ciao")
            .claim("DATI", datiClaim ) 
....