public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        Key<MapperDao> key1 = Key.get(MapperDao.class, Names.named("Mapper1"));
        Provider<DataSource> datasource1 = null;

        Key<MapperDao> key2 = Key.get(MapperDao.class, Names.named("Mapper2"));
        Provider<DataSource> datasource2 = null;

        install(new DaoModule<MapperDao>(key1, MapperDao.class, datasource1));
        install(new DaoModule<MapperDao>(key2, MapperDao.class, datasource2));
    }
}