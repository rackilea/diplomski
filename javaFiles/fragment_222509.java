public final class InterfaceAdapterFactoryTest extends TestCase {

    public void testInterfaceSerialization1(){
        SampleInterface first = new SampleImplementation1(10);
        SampleInterfaceContainer toSerialize = new SampleInterfaceContainer("container", first);

        GsonBuilder gsonBuilder = new GsonBuilder();

        new GraphAdapterBuilder()
            .addType(SampleInterfaceContainer.class)
            .addType(SampleImplementation1.class)
            .addType(SampleImplementation2.class)
            .registerOn(gsonBuilder);
        gsonBuilder.registerTypeAdapterFactory(new InterfaceAdapterFactory(
                SampleInterface.class, new Class<?>[] { SampleImplementation1.class, SampleImplementation2.class }
                ));
        Gson gson = gsonBuilder.create();

        String json = gson.toJson(toSerialize);
        System.out.println(json);
        SampleInterfaceContainer deserialized = gson.fromJson(json, SampleInterfaceContainer.class);

        assertNotNull(deserialized);
        assertEquals(toSerialize.getName(), deserialized.getName());
        assertEquals(toSerialize.getContent().getNumber(), deserialized.getContent().getNumber());
    }

    public void testInterfaceSerialization2(){
        SampleImplementation2 first = new SampleImplementation2(5, "test");
        SampleInterfaceContainer toSerialize = new SampleInterfaceContainer("container", first);
        first.Container = toSerialize;

        GsonBuilder gsonBuilder = new GsonBuilder();

        new GraphAdapterBuilder()
            .addType(SampleInterfaceContainer.class)
            .addType(SampleImplementation1.class)
            .addType(SampleImplementation2.class)
            .registerOn(gsonBuilder);
        gsonBuilder.registerTypeAdapterFactory(new InterfaceAdapterFactory(
                SampleInterface.class, new Class<?>[] { SampleImplementation1.class, SampleImplementation2.class }
                ));
        Gson gson = gsonBuilder.create();

        String json = gson.toJson(toSerialize);
        System.out.println(json);
        SampleInterfaceContainer deserialized = gson.fromJson(json, SampleInterfaceContainer.class);

        assertNotNull(deserialized);
        assertEquals(toSerialize.getName(), deserialized.getName());
        assertEquals(5, deserialized.getContent().getNumber());
        assertEquals("test", ((SampleImplementation2)deserialized.getContent()).getName());
        assertSame(deserialized, ((SampleImplementation2)deserialized.getContent()).Container);
    }
}