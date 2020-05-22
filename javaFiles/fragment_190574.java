public class IntegerPropertyConverter extends AbstractCsvConverter {

   @Override
   public Object convert(String value) {
       return new SimpleIntegerProperty(Integer.parseInt(value));
   }

   @Override
   public String convertToWrite(Object value) {
       IntegerProprety prop = (IntegerProperty) value;
       return String.format("%d", prop.get());
   }

 }