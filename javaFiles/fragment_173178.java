@Select("SELECT * FROM PERSON WHERE NAME = #{name}")
    @Results(value = {
          @Result(property="name", column="name"),
          @Result(property="surname", column="surname"),
          @Result(property="dogs", javaType=List.class, column="name",
                             many=@Many(select="findDogsByPerson"))})
Person findById(String name); 

@Select("SELECT * FROM DOG WHERE ID_PERSON = #{namePerson}")
@Results(value = {
          @Result(property="name", column="name"),
          @Result(property="dogId", column="dogId")})
List<Dog> findDogsByPerson(String namePerson);