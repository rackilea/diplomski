class AbstractRepository

  Set<? extends SuperObject> getObject();


class Repository extends AbstractRepository

  Set<    ConcreteObject   > getObject()