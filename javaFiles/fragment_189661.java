@Aspect
public class TestAccessorsAspect {
    @Pointcut("get(java.util.List com.sample.Test.myList)")
    public void readMyList(){}

    @Pointcut("set(java.util.List com.sample.Test.myList)")
    public void writeMyList(){}
}