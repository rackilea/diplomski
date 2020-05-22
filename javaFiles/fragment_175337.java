public class Goo{

    @Inject
    Provider<Foo> fooProvider;

    public Foo goo(String input){
        fooProvider.setInput(input);
        return fooProvider.get();
    }
}