@Bean
public WebServiceTemplate webServiceTemplate() {
    WebServiceTemplate template = new WebServiceTemplate();
    template.setMessageSender(httpComponentsMessageSender());
    return template;
}