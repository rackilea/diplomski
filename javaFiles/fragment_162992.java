if (!holderMap.isEmpty()) {
    if( holderMap.get("abc") != null ) {
       clientId = holderMap.get("abc");
    } else if ( holderMap.get("pqr") != null ) {
       clientId = holderMap.get("pqr");
    } else if (holderMap.get("def") != null ) {
       clientId = holderMap.get("def");
    }
}