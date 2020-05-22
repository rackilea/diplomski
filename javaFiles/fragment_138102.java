public class AnObjectThatWantsToInjectStuff {

    @Inject
    SomeObject someObject;
    @Inject 
    SomeOtherObject someOtherObject;

    public AnObjectThatWantsToInjectStuff() {
          super();
          DaggerInjector.getComponent().inject(this);

          // you can now use someObject and someOtherObject
    }
}