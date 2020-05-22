public class BeanTwo {

    BeanOne beanOne;


    @Autowired
    public void setBeanOne(BeanOne beanOne) {
        this.beanOne = beanOne;
        System.out.println("From setter "+beanOne);
    }

    public void testMethod() {
        System.out.println("From testMethod "+beanOne);
    }


}