@Autowired
IntegrationFlow itf;

...

    itf.getInputChannel().send(new GenericMessage<>("foo"));