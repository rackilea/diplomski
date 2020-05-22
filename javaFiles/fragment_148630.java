@Component
public class SingletonBean {

    @Autowired
    private ObjectFactory<PrototypeBean> prototypeFactory;

    public void doSomething() {
        PrototypeBean prototypeBean = prototypeFactory.getObject();
        prototypeBean.setX(1);
        prototypeBean.display();
    }
}