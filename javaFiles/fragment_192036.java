KeyPairGenerator kg = KeyPairGenerator.getInstance ("EC");
    kg.initialize (new ECGenParameterSpec ("secp256k1"));
    ECParameterSpec p = ((ECPublicKey) kg.generateKeyPair().getPublic()).getParams();
    System.out.println ("p=(dec)" + ((ECFieldFp) p.getCurve().getField()).getP() );
    ECPoint G = p.getGenerator(); 
    System.out.format ("Gx=(hex)%032x%n", G.getAffineX());
    System.out.format ("Gy=(hex)%032x%n", G.getAffineY());
    //
    byte[] privatekey_enc = DatatypeConverter.parseHexBinary(
            "303E020100301006072A8648CE3D020106052B8104000A042730250201010420"+
            "1184CD2CDD640CA42CFC3A091C51D549B2F016D454B2774019C2B2D2E08529FD");
    // note fixed prefix for PKCS8-EC-secp256k1 plus your private value
    KeyFactory kf = KeyFactory.getInstance("EC");
    PrivateKey k1 = kf.generatePrivate(new PKCS8EncodedKeySpec(privatekey_enc));
    ECParameterSpec p2 = ((ECPrivateKey) k1).getParams();
    System.out.println ("again p=(dec)" + ((ECFieldFp) p2.getCurve().getField()).getP() );