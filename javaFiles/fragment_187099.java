@SomeScope
@Component(modules = Amodule.class)
interface Acomponent {  
    @Baz String baz();
    Subcomp subcomp();
}