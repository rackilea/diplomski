public interface DocumentValidator<K,V> {

    void validate(Map<K, V> documentData, Map<K, V> referenceData, 
                  List<K> referenceKeyList); 

}