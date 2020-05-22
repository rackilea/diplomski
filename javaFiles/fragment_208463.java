public static List<Integer> howmanyeven(int... values){
    List<Integer> res = new ArrayList<>();
    for(int i=0; i<values.length; i++){
        if(values[i]%2 == 0){
            res.add(values[i]);
        }
    } 
    return res;
}