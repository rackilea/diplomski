public class MyComponentBeanInfo<T> extends SimpleBeanInfo {

private final static Class<?> _clazz = MyComponent.class;
PropertyDescriptor[] _properties = null;

public synchronized PropertyDescriptor[] getPropertyDescriptors() {
    if (_properties == null) {
        _properties = Helpers.getPropertyDescriptionsIncludingFluentSetters(_clazz);
    }
    return _properties;
}

public BeanDescriptor getBeanDescriptor() {
    return new BeanDescriptor(_clazz);
}
}