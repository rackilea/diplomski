@Inject
IEclipseContext context;

...

MyClass myClass = ContextInjectionFactory.make(MyClass.class, context);