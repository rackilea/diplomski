private static void initializeCryptoManager() throws Exception {
    //load the NSS modules before creating the second keyStore.

    if (cm == null) { //cm is of type CryptoManager
        while (true) { //the trick.
            try {
                cm = CryptoManager.getInstance();
            } catch (NotInitializedException e2) {
                try {
                    InitializationValues iv = new InitializationValues(NSS_JSS_Utils.getFireFoxProfilePath());
                    //TEST
                    iv.installJSSProvider = false;
                    iv.removeSunProvider = false;
                    iv.initializeJavaOnly = false; //must be false, or native C error if no provider is created.
                    iv.cooperate = false;
                    iv.readOnly = true;
                    iv.noRootInit = true;
                    iv.configDir = NSS_JSS_Utils.getFireFoxProfilePath();
                    iv.noModDB = false;
    //              iv.noCertDB = false; 
    //              CustomPasswordCallback cpc = new  CustomPasswordCallback();
    //              iv.passwordCallback = cpc; //no passwordcallback needed here.
                    iv.forceOpen = false;
                    iv.PK11Reload = false;
                    CryptoManager.initialize(iv);
                    continue; // continue to getInstance.
                } catch (KeyDatabaseException | CertDatabaseException | GeneralSecurityException e) {
                    Traza.error(e);
                    throw e;
                } catch (AlreadyInitializedException e1) {
                    continue; //if is initialized, must go on to get cm.
                }
            } 
            break; //if nothing is catched, must break to end the loop.
        }
    }
}