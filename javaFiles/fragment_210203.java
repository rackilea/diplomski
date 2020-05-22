public class ConvertListToArray implements CustomConverter{
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, 
    Class<?> destinationClass, Class<?> sourceClass) {
        if(sourceFieldValue==null)
            return null;

        if(sourceFieldValue instanceof List && ((List<?>) sourceFieldValue).size()>0){
            List<Field> listOfFields = (List<Field>)sourceFieldValue;

            String[][] destinationValue = new String[2][2];
            for (int i = 0; i<2;i++){
                 Field f = listOfFields.get(i);
                 for (int j = 0;j<f.getItems().size();j++){
                     destinationValue[i][j] = f.getItems().get(j);
                 }
             }
             return destinationValue;

         }
        return null;
    }
}