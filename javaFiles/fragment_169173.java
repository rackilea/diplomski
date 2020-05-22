String a = "[ ";
    for (int i = 0; i < myList.size(); i++) {
        String b = "[ \"" + myList.get(i).getCurrent_day() + "\" , "
                + myList.get(i).getOpen_val() + "],";
        if(i==myList.size() -1)
            a += b;
        else
            a += b+",";
    }
    a += " ]";