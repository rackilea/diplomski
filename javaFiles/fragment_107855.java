public class AutoIncrementorBulk {

    @AfterMapping
    public /*static*/ void autoIncrementId(C source, @MappingTarget A target) {
        //here you iterate the list and increment the ids
    }
}