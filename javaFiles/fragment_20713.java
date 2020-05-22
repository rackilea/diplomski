@Inject
private BeanModelSource beanModelSource;

@Inject
private Messages messages;

public BeanModel<Celebrity> getModel() {
  return beanModelSource.createDisplayModel(Celebrity.class, messages);
}