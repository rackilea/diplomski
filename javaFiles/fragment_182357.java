int[] convert(JSONArray arr){
    int[] result = new int[arr.length()];
    for(int i = 0; i < result.length; i++){
        result[i] = arr.getInt(i);
    }
    return result;
}