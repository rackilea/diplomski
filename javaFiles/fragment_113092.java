@Mapper( componentModel = "spring") 
public class CustomMapper {

    protected ObjectMapper mapper;


    @Autowired
    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
   } 

}