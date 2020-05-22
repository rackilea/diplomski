@Autowired
private RequestMappingHandlerMapping requestMappingHandlerMapping;

@PostConstruct
public void init() {
    Map<RequestMappingInfo, HandlerMethod> handlerMethods =
                              this.requestMappingHandlerMapping.getHandlerMethods();

    for(Entry<RequestMappingInfo, HandlerMethod> item : handlerMethods.entrySet()) {
        RequestMappingInfo mapping = item.getKey();
        HandlerMethod method = item.getValue();

        for (String urlPattern : mapping.getPatternsCondition().getPatterns()) {
            System.out.println(
                 method.getBeanType().getName() + "#" + method.getMethod().getName() +
                 " <-- " + urlPattern);

            if (urlPattern.equals("some specific url")) {
               //add to list of matching METHODS
            }
        }
    }       
}