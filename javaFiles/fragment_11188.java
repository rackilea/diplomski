RsaJsonWebKey rsaJwk1 = RsaJwkGenerator.generateJwk(2048);
    RsaJsonWebKey rsaJwk2 = RsaJwkGenerator.generateJwk(2048);
    EllipticCurveJsonWebKey ecJwk = EcJwkGenerator.generateJwk(EllipticCurves.P256);

    JsonWebKeySet jwks = new JsonWebKeySet(rsaJwk1, rsaJwk2, ecJwk);

    String jwksJson = jwks.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);

    System.out.println(jwksJson);