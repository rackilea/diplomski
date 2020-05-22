public class XYZ {

public static RouteBuilder routen() {
        RouteBuilder builder = new RouteBuilder() {
            public void configure() {
                errorHandler(deadLetterChannel("mock:error"));

                from("file:documentIn").id("DefaultRoute")
                .to("file:documentOut");
            }
        };
        return builder;
    }
}