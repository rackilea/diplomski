signingConfigs {
    release {
        Properties keystoreProps = new Properties()
        keystoreProps.load(new FileInputStream(file('keystore.config')))

        keyAlias keystoreProps['keyAlias']
        keyPassword keystoreProps['keyPassword']
        storePassword keystoreProps['storePassword']
        storeFile file('keystore.jks')
    }
}