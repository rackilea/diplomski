@JsonFilter("PersonFilter")
public class Person
{
   private List<Integer> integerList; 
   private Integer creditCardNUmber;
   private String firstName;
   private String lastName;

public static FilterProvider getFilter(){
    Set<String> fieldsToFilter= new HashSet<>(Arrays.asList("creditCardNUmber","integerList");
    SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter
            .serializeAllExcept(fieldsToFilter);
    FilterProvider filters = new SimpleFilterProvider()
            .addFilter("PersonFilter", theFilter);
    return filters;
}
}