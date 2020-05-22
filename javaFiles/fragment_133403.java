@Test
public void testSequenceCreation() throws ClassNotFoundException {
    EnvironmentConfig econf = EnvironmentConfig.DEFAULT.setAllowCreate(true);
    Environment env = new Environment(envHome, econf);

    StoreConfig sconf = StoreConfig.DEFAULT.setAllowCreate(true);
    EntityStore store = new EntityStore(env, "TestStore", sconf);

    store.setPrimaryConfig(FakeEntity.class, 
            DatabaseConfig.DEFAULT.setAllowCreate(true));
    store.setSequenceConfig("testSequence", SequenceConfig.DEFAULT.setAllowCreate(true));

    Sequence seq = store.getSequence("testSequence");
    Assert.assertEquals(0, seq.get(null, 1));
    Assert.assertEquals(1, seq.get(null, 1));
    Assert.assertEquals(2, seq.get(null, 1));

    store.sync();

    seq.close();
    store.close();
    env.close();        
}