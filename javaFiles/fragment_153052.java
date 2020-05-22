public <V> Map<Integer, V> readXML(Map<Integer, V> values, Class<V> clazz) {
    if(clazz == Integer.class) {
        ...
    } else if// or if all the class type has same implementation use the 
             // || operator in the above if condition only. 
            ...
    //and finally
    else {
        // either throw **IllegalArgument/Unsupported operation** exception
        // for the type 'V' Or handle in any other way you like to implement
    }
}