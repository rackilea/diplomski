boolean b = sig.verify(DEREncodeSignature(CertSign));
    if (b) {
        Logger.getLogger(CardManager.class.getName()).log(Level.INFO, "verificato");
    }
    else {
        Logger.getLogger(CardManager.class.getName()).log(Level.INFO, "controllo fallito");
    }