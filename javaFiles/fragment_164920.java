private int getIndexByProperty(String yourString) {
        for (int i = 0; i < objList.size(); i++) {
            if (object1 !=null && object1.getIdNum().equals(yourString)) {
                return i;
            }
        }
        return -1;// not there is list
    }