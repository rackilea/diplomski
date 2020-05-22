@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class NoEndpointFoundEndpointMapping implements EndpointMapping {

    @Override
    public EndpointInvocationChain getEndpoint(MessageContext messageContext) throws Exception {

        throw new MyCustomException(...);
    }
}