public class MyPage {

     @Component(parameters = "dataHolder=dataHolder")
     private MyForm formComponent;

     @Component(parameters = "dataHolder=dataHolder")
     private MyGrid gridComponent;

     @Persist
     @Property
     private MyDataHolder dataHolder;

}

public class MyFormComponent {

    @Parameter
    private MyDataHolder dataHolder;

    @OnEvent(EventConstants.SUCCESS)
    void formSubmitted() {
        this.dataHolder = new DataHolder(...);
    }

}