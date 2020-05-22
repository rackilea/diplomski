public class ThingFactory {

    @Autowired 
    private ApplicationContext ctx;

    public Thing GetThing(String stateCode, Date date){
        Thing result;
        if(stateCode == "MA") {
            result = ctx.getBean("someBean")
        }
        else {
            result = ctx.getBean("someOtherBean")
        }
        return result;
    }
}