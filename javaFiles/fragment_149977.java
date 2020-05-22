try {
    Jwts.parser().setSigningKey(PRIVATE_KEY).parseClaimsJws(token).getBody().getSubject();
    validation = true;
} catch (ExpiredJwtException e) {
    System.out.println(" Token expired ");
} catch (SignatureException e) {
    Logger.getLogger(JWTController.class.getName()).log(Level.ERROR, e);
} catch(Exception e){
    System.out.println(" Some other exception in JWT parsing ");
}