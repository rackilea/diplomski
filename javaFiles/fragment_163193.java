public static ArrayList<String> markLength4(ArrayList<String> list) {

    int i = 0;
    boolean found = false;
    int pos = 0;

    while(i < list.size() && !found){
        if (list.get(i).length() == 4) {
            found = true;
            pos = i;
        }
        i++;
    }
    list.add(pos, "****");
    return list;
}