@Stateless
@EJB(name="myBeanRef", beanInterface=MyBean.class)   // this creates only reference - you will need to initialize it for example via initialConetxt.lookup()
public class EJBTests{
    @EJB (name=”ejb/bean1”)  // this injects bean named ejb/bean1
    MyBean1 bean1;

    MyBean2 bean2;

    ....
    @EJB (name="ejb/bean2")   // this injects bean using setter method
    public void setEcho(MyBean2 bean2) {
       this.bean2 = bean2;
    }
}