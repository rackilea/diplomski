public static String getSequence(int pos){
    StringBuilder sb = new StringBuilder();
    pos = pos -1;
    while (pos >= 0){
        sb.insert(0,(char)(start+(pos % range)));
        pos /= range;
        pos = pos -1;
    }

    return sb.toString();
}