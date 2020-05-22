if (!token.isInternalCryptoToken() && !token.isInternalKeyStorageToken()){ // If not Internal Crypto service, neither Firefox CA store
    if (token.isPresent() ) { // when the card is inserted
        if (!token.isLoggedIn()){ // Try to login. 3 times.
            Traza.info("Reading the certificates from token " + token.getName() + ". Loggining... ");
            while (UtilTarjetas.tries <= 3) {
                try {
                //TEST
                    token.setLoginMode(NSS_JSS_Utils.LOGIN_MODE_ONE_TIME); 
                    token.login((PasswordCallback) new CustomPasswordCallback());
                    UtilTarjetas.prevTryFailed = false;
                    cm.setThreadToken(token);
                    break;
                } catch (IncorrectPasswordException e){
                    UtilTarjetas.prevTryFailed = true;
                    UtilTarjetas.tries ++;
                } catch (TokenException e) {
                    UtilTarjetas.prevTryFailed = true;
                    UtilTarjetas.tries ++;
                } 
            }

                // if tries > 3
                if (UtilTarjetas.tries > 3) {
                    Traza.error("The token " + token.getName() + " is locked now. ");
                    throw new IOException("You have tries 3 times and now the card is locked. ");
                }
            }

            if (token.isLoggedIn()) {
                ....
            }