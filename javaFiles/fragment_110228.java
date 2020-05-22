@Data @Entity
public class Ent1{
  public Ent1() {}
  String id;
  String name;
}

@Data @Entity
public class Ent2{
  public Ent2() {}
  String id;
  String name;
}

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTO{
  String id1,id2,name1,name2;
}

@Mapper
public interface EntitiesDtoMapper{  

  EntitiesIcspDtoMapper INSTANCE = Mappers.getMapper(EntitiesDtoMapper.class);

  @Mappings({
    @Mapping(source="ent1.id", target = "id1"),
    @Mapping(source="ent1.name", target = "name1"),
    @Mapping(source="ent2.id", target = "id2"),
    @Mapping(source="ent2.name", target = "name2")
  })
  DTO EntitiesToDto(Ent1 ent1, Ent2 ent2);

  @Mappings({
    @Mapping(source="id1", target = "id"),
    @Mapping(source="name1", target = "name"),
  })
  Ent1 DtoToEnt1(DTO dto);

  @Mappings({
    @Mapping(source="id2", target = "id"),
    @Mapping(source="name2", target = "name"),
  })
  Ent2 DtoToEnt2(DTO dto); 

}