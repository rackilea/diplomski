public String put(String id, String name) {
    String temp = null;//initialize your attribute with null or "" empty 
    for (int i = 0; i < ids.length; i++) {
        if (!(ids[i].equalsIgnoreCase(id))) {
            if (ids.length < 10) {
                ids[ids.length] = id;
                names[names.length] = name;
            } else {
                System.out.println("There are too many members in the collection");
            }
        } else if ((ids[i].equalsIgnoreCase(id))) {
            temp = names[i];
            names[i] = name;
        }
    }
    //return temp in the end if it not changes i the else block it return null or ""
    return temp;
}