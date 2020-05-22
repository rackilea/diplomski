public class MyBean{

    @Autowired(required=false)
    public void setOtherBean(OtherBean o){this.otherBean=o;}
    private OtherBean otherBean;

}