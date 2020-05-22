public static List<YourInterface> getList(int list){
    List<YourInterface> result = new ArrayList<>();
    if(list == 1){
        // your initial type
         List<Object1> firstList = new ArrayList<>();
         result.addAll(firstList);
    } else {
        // your initial type
        List<Object2> secondList = new ArrayList<>();
        result.addAll(secondList);
    }
    return result;
}