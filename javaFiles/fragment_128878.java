public class CustomBean {
   ...
   public static void main(String[] args) {
     ...
     HeaderColumnNameTranslateMappingStrategy strategy = new CustomStrategy<CustomBean>();
     strategy.setType(CustomBean.class);
     strategy.setColumnMapping(mapping);
     ...

     BeanToCsv bean = new CustomBeanToCsv<CustomBean>();
     ...
   }

   static class CustomStrategy<T> extends HeaderColumnNameTranslateMappingStrategy {

    @Override
    public void setColumnMapping(Map columnMapping) {
        super.setColumnMapping(columnMapping);
        header = new String[columnMapping.size()];
        int i = 0;
        for (Map.Entry entry : columnMapping.entrySet()) {
            header[i] = entry.getKey().toUpperCase();
            i++;
        }
    }

     public String[] getHeader() {
         return header;
     }
   }

   static class CustomBeanToCsv<T> extends BeanToCsv {
     @Override
     protected String[] processHeader(MappingStrategy mapper) throws IntrospectionException {
         if (mapper instanceof CustomStrategy) {
             return ((CustomStrategy) mapper).getHeader();
         } else {
             return super.processHeader(mapper);
         }
     }
   }
}