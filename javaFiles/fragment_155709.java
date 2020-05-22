public ArrayList<String> concatLists(ArrayList<ArrayList<String>> list) {
    ArrayList<String> catStrs = new ArrayList<String>();
    int len = list.size();
    if (len == 1) {
        catStrs.addAll(list.get(0));
        return catStrs;
    }
    ArrayList<String> myStrs = list.get(0);
    ArrayList<ArrayList<String>> strs = new ArrayList<ArrayList<String>>();
    strs.addAll(list.subList(1, len));
    ArrayList<String> retStrs = concatLists(strs);
    for (String str : myStrs) {
        for (String retStr : retStrs) {
            catStrs.add(str+retStr);
        }
    }
    return catStrs;
}