@Provider
public class ProviderLoggingListener implements ApplicationEventListener {

    @Override
    public void onEvent(ApplicationEvent event) {
        switch (event.getType()) {
            case INITIALIZATION_FINISHED: {
                Set<Class<?>> providers = event.getProviders();
                ResourceConfig immutableConfig = event.getResourceConfig();
                ResourceModel resourcesModel = event.getResourceModel();
                break;
            }
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        return null;
    }
}