@TypeDef( name = "registeredName",
    defaultForType = org.jasypt.hibernate.type.EncryptedStringType.class,
    typeClass = org.jasypt.hibernate.type.EncryptedStringType.class,
    parameters = {
        @Parameter(name="algorithm", value="PBEWithMD5AndTripleDES"),
        @Parameter(name="password", value="password"),
        @Parameter(name="keyObtentionIterations", value="1000")
    }
)