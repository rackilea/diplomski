public static KeyPair keyPairFromPEMFile(String filename, final String password) throws Exception {

    if ( !bcInitialized ) {
        Security.addProvider(new BouncyCastleProvider());
        bcInitialized = true;
    }

    FileReader keyFile = new FileReader(filename);
    PEMReader pemReader = new PEMReader(keyFile,  new PasswordFinder() {

        public char[] getPassword() {
            return password.toCharArray();
        }});

    return (KeyPair)pemReader.readObject();

}