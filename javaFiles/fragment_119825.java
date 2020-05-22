for (int i = 0; i < array.size(); i++) {
    if (uid.equals(array.get(i).getID())) {//I am using equals since uid is Object
                                           //and I want to compare its value, not
                                           //reference
        array.remove(i);
        break;
    }
}