@RegisterMapper(CustomizeObjectMapper.class)
public interface CustomizeObjectQuery {

    @SqlQuery("Select uuid, other_column from schema.relation")
    List<customizedObject> get();
}