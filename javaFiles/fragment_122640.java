public void sendEncryptedKeyToServer () {

    // the next line is almost certainly part of the problem
    // but I don't know how to fix!!!
    //AppComponent component = DaggerAppComponent.builder().appModule(new AppModule()).build(); //you don't need this here at all

    //AESCipherService cipherService = component.provideCipherService(); //already provided in constructor