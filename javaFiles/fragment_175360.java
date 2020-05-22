public static List<DataEntityInteger> removeZeroValue(List<DataEntityInteger> list) {   
    Iterator<DataEntityInteger> iter = list.iterator();          
    while (iter.hasNext()) {                                                              
        DataEntityInteger entityInteger = iter.next();                                               
        if (entityInteger.getValue().equals(0)) {                                                         
            iter.remove();                                                                       
        }                                                                                            
    }                                                                                                
    return list;                                                                                     
}