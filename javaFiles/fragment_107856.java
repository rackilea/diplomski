public class AutoIncrementorContext {

    private int counter = 0;
    @AfterMapping
    public void autoIncrementId(D source, @MappingTarget B target) {
        //here you use your counter, because you are only using this instance during one mapping
    }
}