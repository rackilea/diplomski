@Data
@Builder
public class MyModel {

    private String myField1;

    private String myField2;

    private String myField3;

    public static class MyModelBuilder {
        public MyModelBuilder myField3(String myField3) {
            this.myField3 = "Hello " + myField3;
            return this;
        }
    }
}