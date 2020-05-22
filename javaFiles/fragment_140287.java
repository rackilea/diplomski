public abstract class BeanWriter<T extends Bean> {
    public abstract boolean writeBean(T bean);
}

public class BeanAWriter extends BeanWriter<BeanA> {
    public boolean writeBean(BeanA bean) {
        bean.accessBeanAProperty();
    }
}