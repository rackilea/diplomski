...
import javax.validation.constraints.NotNull;
import org.springframework.messaging.MessageHandler;
import org.springframework.xd.module.options.spi.ModuleOption;
import org.springframework.xd.reactor.BroadcasterMessageHandler;

@Configuration
@EnableIntegration
@ComponentScan(value = { "mypackage" })
public class ModuleConfiguration {

    private int intParam;

    @NotNull
    public int getIntParam() {
        return intParam;
    }

    @ModuleOption("help text that appears if you type 'module info ...' in the XD shell")
    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }

    @Autowired
    private MyReactorStream myReactorStream;

    @Bean
    public MessageChannel input() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel output() {
        return new DirectChannel();
    }

    @Bean
    MyReactorStream myReactorStream() {
        return new myReactorStream();
    }

    @Bean
    @ServiceActivator(inputChannel = "input")
    MessageHandler messageHandler() {
        BroadcasterMessageHandler handler = new BroadcasterMessageHandler(myReactorStream);
        handler.setOutputChannel(output());
        return handler;
    }    
}