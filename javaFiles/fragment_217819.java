String claimName = "long"
  Long claimVal = new Long(5)
  String compact = Jwts.builder().setClaims([(claimName): claimVal]).compact();
  Claims claims = Jwts.parser().parse(compact).body as Claims
  // `claims.get` throws `RequiredTypeException`
  assert claims.get(claimName, Long) == claimVal