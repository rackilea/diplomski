public class Main {
    public static void main(String... args) {
        Injector i = Guice.createInjector(new MyModule());

        MapperDao mapper1 = i.getInstance(Key.get(MapperDao.class, Names.named("Mapper1")));
        MapperDao mapper2 = i.getInstance(Key.get(MapperDao.class, Names.named("Mapper2")));
    }
}