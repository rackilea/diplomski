public abstract class PageObject implements InitializingBean {
...
public void afterPropertiesSet() {
    Class clazz = this.getClass();
    do {
        initializeElements(clazz);
        clazz = clazz.getSuperclass();
    } while (clazz != null);
}