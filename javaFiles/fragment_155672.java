public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("Yes");
    list.add("No");
    list.add("Maybe");
    list.add("Probably");
    list.add("Never");

    List<String> orList = addOr(list);
    System.out.println(orList);
}

public static List<String> addOr(List<String> list){
    List<String> newList = new ArrayList<>();
    int count = 0;
    for(String text : list){
        count++;
        newList.add(text);
        if (count != list.size()){
            newList.add("Or");
        }
    }
    return newList;
}