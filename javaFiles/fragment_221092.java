public static String pad_num(String line){
    String[] groups = line.split("-");
    String left = groups[0],
            right = groups[1];

    if(left.length() < right.length()) {
        do {
            left = '0'+left;
        } while (left.length() < right.length());
    } else if(right.length() < left.length()) {
        do {
            right = '0'+right;
        } while (right.length() < left.length());
    }

    return left+'-'+right;
}