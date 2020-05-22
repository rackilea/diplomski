@Mapper (componentModel = "spring", 
         unmappedTargetPolicy = ReportingPolicy.ERROR,
         uses = { ZipCodeMapper.class, PersonLanguageMapper.class })
public interface PersonMapper {
    // Your code here
}