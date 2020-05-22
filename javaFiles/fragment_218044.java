Background:
  Given message creator com.consol.citrus.FooMessageCreator

public class FooMessageCreator {
    @MessageCreator("fooResponse")
    public Message createEchoResponse() {
        return new DefaultMessage("Hi my name is Foo!")
                    .setHeader("operation", "sayHello");
    }
}