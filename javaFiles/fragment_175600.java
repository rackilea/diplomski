@Test
public void shouldMatchIssuedAtAndExpiration() {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    Instant expiration = issuedAt.plus(3, ChronoUnit.MINUTES);

    log.info("Issued at: {}", issuedAt);
    log.info("Expires at: {}", expiration);

    String jws = Jwts.builder()
            .setIssuedAt(Date.from(issuedAt))
            .setExpiration(Date.from(expiration))
            .signWith(key)
            .compact();

    Claims claims = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(jws)
            .getBody();

    assertThat(claims.getIssuedAt().toInstant(), is(issuedAt));
    assertThat(claims.getExpiration().toInstant(), is(expiration));
}