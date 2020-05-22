for(String i : list_old) {
    for (String j: tinydb.getListString("list_new")) {
        if (i.contains(j)) {
            list_old.remove(i);
            break;
        }
    }
}