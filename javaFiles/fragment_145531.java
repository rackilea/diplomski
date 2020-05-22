public static <X> boolean allequal( List<Collection<X>> listOfColls ){
    if( listOfColls.size() <= 1 ) return true;
    int nel = listOfColls.get(0).size();
    for( int i = 1; i < listOfColls.size(); ++i ){
        if( listOfColls.get(i).size() != nel ) return false;
    }
    for( int i = 1; i < listOfColls.size(); ++i ){
        if( ! listOfColls.get(i).equals( listOfColls.get(0) ) ) return false;
    }
    return true;
}