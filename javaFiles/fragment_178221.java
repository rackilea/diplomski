public interface MapperEntity {

    @Select("select * from post_locations")
    @Results({
        @Result(id=true, property = "id.postId", column = "post_id"),
        @Result(id=true, property = "id.locationId", column = "location_id"),
        //OTHER PROPERTIES...
      })
    public List<PostLocations> findAll();

}