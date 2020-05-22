public static String[] addToArray(String[] names, int i, String name){
    if (i < names.length){
        names[i] = name;
    }
    else {
        String[] temp;
        temp = new String[names.length + 10];
        System.arraycopy(names, 0, temp, 0, names.length);
        names = addToArray(temp, i, name);
    }
    return names;
}