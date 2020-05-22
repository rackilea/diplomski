private ArrayList<IWidget> widgets;

@PostConstruct
public void postConstruct(Composite parent) {
    lookupWidgets();
}

private void lookupWidgets() throws InvalidSyntaxException {
    widgets = new ArrayList<>();

    BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext(); 
    Collection<ServiceReference<IWidget>> serviceReferences = context.getServiceReferences(IWidget.class, null);

    for (ServiceReference<IWidget> serviceReference : serviceReferences) {
        IWidget widget = (IWidget) context.getService(serviceReference);
        widgets.add(widget);
    }
}