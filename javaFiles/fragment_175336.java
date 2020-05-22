public class FooProvider implements Provider<Foo>

    @Inject
    private Injector injector;

    private String input;

    public void setInput(String input){
        this.input = input;
    }

    @Override
    public Foo get(){
        if(input.equals("bar")){
            injector.getInstance(Bar.class); // Bar implements Foo
        }
        else{
            injector.getInstance(Baz.class; // Baz implements Foo
        }
    }
}