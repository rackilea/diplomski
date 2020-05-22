public void testFactoryIfNetworkResponseBuilderNotFound() {
    Factory factory = spy(new Factory());
    when(factory.getNetworkResponseBuilderClass()).thenThrow(
        new ClassNotFoundException()
    );
    // The rest of your test here
}

public void testFactoryIfNetworkResponseBuilderFound() {
    Factory factory = spy(new Factory());
    when(factory.getNetworkResponseBuilderClass()).thenReturn(
        OkHttpNetworkResponse.Builder.class
    );
    // The rest of your test here
}