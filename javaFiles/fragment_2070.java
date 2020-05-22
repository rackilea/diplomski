public class BeanCounterMaster <C extends BeanCounter<B>, B extends Bean> {
    public void mergeBeans(C des, C src) {
        for (B bean : src.getBeans()) {
            des.addBean(bean);
        }
    }
}