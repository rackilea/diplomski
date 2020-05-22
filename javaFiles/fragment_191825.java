public class MyServerResource extends ServerResource {
    @Post
    public SomeOutputBean handleBean(SomeInputBean input) {
        (...)
        SomeOutputBean bean = new SomeOutputBean();
        bean.setId(10);
        bean.setName("some name");
        return bean;
    }
}