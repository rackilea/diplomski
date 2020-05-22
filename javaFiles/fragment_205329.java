@Path("/hello/world")
    public class HelloWorldResource {

        @GET
        public String get() {
            return "hello";
        }

    }