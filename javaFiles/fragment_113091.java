public class ThingFactory {
    public Thing GetThing(String stateCode, Date date){
        return (Thing) ctx.getBean("Thing_" + stateCode);

   }
}