public interface DocumentValidator<K, V, K2, V2> {

    void validate(Map<K, V> documentData, Map<K2, V2> referenceData, 
                  List<K2> referenceKeyList); 

}

public class ExcelValidator implements DocumentValidator<String,String,String,Integer>{

    @Override
    public void validate(Map<String, String> documentData,
                         Map<String, Integer> referenceData, 
                         List<String> referenceKeyList) {
        // TODO Auto-generated method stub

    }
}