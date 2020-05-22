PGPSignatureGenerator sGen = new PGPSignatureGenerator(new JcaPGPContentSignerBuilder(skey.getPublicKey().getAlgorithm(), PGPUtil.SHA256).setProvider("BC"));
        PGPSignatureSubpacketGenerator  spGen = new PGPSignatureSubpacketGenerator();

        sGen.init(PGPSignature.CANONICAL_TEXT_DOCUMENT, prKey);
        Iterator userIDs = skey.getPublicKey().getUserIDs();
        if (it.hasNext()) {
            spGen.setSignerUserID(false, (String)userIDs.next());
            sGen.setHashedSubpackets(spGen.generate());
        }

        ArmoredOutputStream aos = new ArmoredOutputStream(baos);
        aos.beginClearText(PGPUtil.SHA256);

        sGen.update(dataBytes);
        aos.write(dataBytes);

        aos.endClearText();

        BCPGOutputStream bOut = new BCPGOutputStream(aos);
        sGen.generate().encode(bOut);

        aos.flush();
        aos.close();