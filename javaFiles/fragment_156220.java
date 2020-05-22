public interface Db2Mapper extends MyBatisMapper<SomeType> {

  @Override
  @Select(value = ...)
  @Options(statementType = StatementType.CALLABLE)
  @Results({...}) 
  List<SomeType> select(Map<String, Object> parameters);
}

@Service
public class Db2Service{
  @Autowired
  private Db2Mapper db2Mapper;

  //...
}