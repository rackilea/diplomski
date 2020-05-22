public class ListConverter implements Converter<List<SecondObject>, List<ThirdObject>> {

    @Override
    public List<ThirdObject> convert(MappingContext<List<SecondObject>, List<PromoConditionEntity>> context) {
       //A java 8 mapping example
       return context.getSource()
          .stream()
          .map(this::convertToThirdObject)
        .collect(Collectors.toList());
    }

    private ThirdObject convertToThirdObject(SecondObject s) {
       //your impl map SecondObject to ThirdObject
       ...
     }
}