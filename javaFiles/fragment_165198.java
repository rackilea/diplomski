@WebService(endpointInterface = "com.bot.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getString(String name) {
        return "Hello World received input = " + name;
    }

}