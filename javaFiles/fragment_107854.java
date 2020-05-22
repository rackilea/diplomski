public class AutoIncrementorThreadLocal {

    @AfterMapping
    public /*static*/ void autoIncrementId(D source, @MappingTarget B target) {
        //here you use the ThreadLocal and do something like getAndIncrement
    }
}