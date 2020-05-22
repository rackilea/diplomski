ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-extensions", "test-type",
            "no-default-browser-check", "ignore-certificate-errors",
            "--disable-notifications",
            "--disable-offer-store-unmasked-wallet-cards",
            "--disable-autofill-keyboard-accessory-view");
    options.addArguments("--disable-translate");