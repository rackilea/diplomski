public interface MapperProvince {

    @Select("select * from PROVINCE")
    @Results({
        @Result(id=true, property = "id", column = "ID"),
        @Result(property="language", column="LANG_CODE",
        one=@One(select="com.example.MapperProvince.findByCode"))
      })
    public List<Province> findAll();

    @Select("select * from PROVINCE where ID = {id}")
    @Results({
        @Result(id=true, property = "id", column = "ID"),
        @Result(property="language", column="LANG_CODE",
        one=@One(select="com.example.MapperProvince.findByCode"))
      })
    public Province findById(long id);


    @Select("select * from LANGUAGE where CODE = {code}")
    @Results({
        @Result(id=true, property = "id", column = "id"),
        @Result(property = "code", column = "code"),
        @Result(property = "name", column = "name")
      })
    public Language findByCode(String code);

}