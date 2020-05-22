while (it.hasNext()) {
        PGPSignature sig = (PGPSignature) it.next();
        sig.init(new >JcaPGPContentVerifierBuilderProvider().setProvider("BC"), signing_key);

       // here you need the original message
        sig.update("signature original message".getBytes());

        // now you can try to verify!
        println(sig.verify());
}