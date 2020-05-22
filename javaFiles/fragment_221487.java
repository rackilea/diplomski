@ServerEndpoint(value = "/call-stream", configurator = SpringConfigurator.class)
public class CallStreamWebSocketController
{  
    private IntelligentResponseService responseServiceFacade = SpringContext.getBean(IntelligentResponseService.class);

    // Other methods
}