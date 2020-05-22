ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010);
ExchangeCredentials credentials = new WebCredentials("USERNAME", "PASSWORD");       
try {
    service.setCredentials(credentials);
    service.setUrl(new URI("URL"));
    ItemId id = new ItemId("ITEM ID");
    new Item(service);
    Item item = Item.bind(service, id);
    EmailMessage email = (EmailMessage) item;
    if (ewsModel.getMarkEmailAsRead().booleanValue()) {
        email.setIsRead(true);
        email.update(ConflictResolutionMode.AlwaysOverwrite);           
    }}