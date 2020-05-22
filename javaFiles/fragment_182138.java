public class Wrapper {

    @Embedded
    public FirstEntity firstEntity;

    @Relation (parentColumn = columnOfFirstEntity, entityColumn = columnOfSecondEntity)
    public List<SecondEntity> secontEntities;

    //Insert getters and setters

}