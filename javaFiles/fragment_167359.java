public String doesexist(ArrayList<ArrayList<String>> arrayList, String s) {

    for (int i = 0; i < arrayList.size(); i++) {
        String get = arrayList.get(i).get(0);
        if (get.trim().equalsIgnoreCase(s.trim())) {
            return arrayList.get(i).get(1);
        }
    }
    return "-1";
 }