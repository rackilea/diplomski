@Inject @Any
private Instance<IService> iServiceInstance;

...

IService service = iServiceInstance.select(new MyQualifierLiteral("someValue")).get();