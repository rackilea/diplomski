public static List listStrToListT(String str) {
    String[] idStrs = str.replace(" ", "").split(",");
    List uids = new ArrayList();
    for (String idStr : idStrs) {
        uids.add((Object)idStr);
    }
    return uids;
}

// main method:
List lst = listStrToListT("1,2,3");
System.out.println(lst);