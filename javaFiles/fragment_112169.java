public static String find(String value, ArrayList<String> list){
    int count = 1;
    String test = value;
    while(list.contains( test )) {
        test = value+count;
        count++;
    }
    return test;
}