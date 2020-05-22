class MyDslRuntimeModule extends AbstractMyDslRuntimeModule {

    override bindIValueConverterService() {
        return MyDslValueConverters
    }

}