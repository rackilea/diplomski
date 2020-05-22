public static BytecodeProvider buildBytecodeProvider(Properties properties) {
    String provider = ConfigurationHelper.getString( BYTECODE_PROVIDER, properties, "javassist" );
    LOG.bytecodeProvider( provider );
    return buildBytecodeProvider( provider );
}

private static BytecodeProvider buildBytecodeProvider(String providerName) {
    if ( "javassist".equals( providerName ) ) {
        return new org.hibernate.bytecode.internal.javassist.BytecodeProviderImpl();
    }

    LOG.unknownBytecodeProvider( providerName );
    return new org.hibernate.bytecode.internal.javassist.BytecodeProviderImpl();
}