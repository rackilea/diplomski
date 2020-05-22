public static List<DataEntityInteger> removeZeroValue(List<DataEntityInteger> list) {                
    for (int a=0; a<list.size(); a++) {                                                              
        DataEntityInteger entityInteger = list.get(a);                                               
        if (entityInteger.getValue().equals(0)) {                                                         
            list.remove(a);   
            a--;                                                                       
        }                                                                                            
    }                                                                                                
    return list;                                                                                     
}