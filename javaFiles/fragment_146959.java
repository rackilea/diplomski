public String[] extractArray(final String str){
    final String strNoBrace = str.substring(1,str.length()-1);
    String[] tempResult = strNoBrace.split(",");
    if(tempResult==null) return null;
    String[] result = new String[tempResult.size()];
    for(int i=0,size=tempResult.size();i<size;++i){
        String temp = tempResult[i];
        result[i] = temp.substring(1,temp.length()-1);
    }
    return result;
}