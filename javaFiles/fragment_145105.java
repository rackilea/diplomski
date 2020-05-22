public class TestImpl {
    private final String property1;
    private final Integer property2;
    private final IService service;


        @Inject
        public TestImpl(@Named("Property1") String property1, @Named("Property2") Integer property2, IService service) {
           this.property1 = property1;
           this.property2 = property2;
           this.service= service;
        }
    }
}