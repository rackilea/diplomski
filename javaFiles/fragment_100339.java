for (AudioFile _data : itemsAll) {
    String[] subStringsArray = _data.getSubStrings();
    for(String subString : subStringsArray){
        if(subString.equals(constraint)){
           suggestions.add(_data);
           break;
        }
     }
 }