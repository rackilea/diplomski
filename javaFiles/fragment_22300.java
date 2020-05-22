KeyFactory keyFactory;
    KeyPairGenerator kpg;
    DHPublicKey originalDhPubKey, fromSpecsDhPubKey;
    DHPublicKeySpec dhPubKeySpecs;
    KeyPair kp;
    BigInteger p, g, y;

    // generate a DH key pair
    kpg = KeyPairGenerator.getInstance("DH");
    kp = kpg.generateKeyPair();

    // get the DH public key
    originalDhPubKey = (DHPublicKey) kp.getPublic();
    // get P, G and Y specs
    p = originalDhPubKey.getParams().getP();
    g = originalDhPubKey.getParams().getG();
    y = originalDhPubKey.getY();

    // get a DH KeyFactory
    keyFactory = KeyFactory.getInstance("DH");

    // create a DHPublicKeySpec with the specs you have
    dhPubKeySpecs = new DHPublicKeySpec(y, p, g);

    // get the DHPublicKey
    fromSpecsDhPubKey = (DHPublicKey) keyFactory.generatePublic(dhPubKeySpecs);

    // Check that the DH public values are equal
    System.out.println(originalDhPubKey.getY().equals(fromSpecsDhPubKey.getY()));