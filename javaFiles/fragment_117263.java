@Component(modules={SomethingModule.class})
//scope if needed
public interface SomethingComponent {
    @Named("something")
    Handler handler();

    void inject(ThatThingy thatThingy);
}