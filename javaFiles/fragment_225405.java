ArrayList<ArrayList<String>> al3list = new ArrayList<ArrayList<String>>();
Set<String> al2set = new HashSet<String>(al2);
for (List<String> tempList : al4) {
    ArrayList<String> al3 = new ArrayList<String>();
    for (String temp : tempList)
        al3.add(al2set.contains(temp) ? "Yes" : "No");
    al3list.add(al3);
}