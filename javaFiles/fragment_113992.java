public static String getStrfinal(){

    StringBuilder sb = new StringBuilder();

    char last = 0;
    int count = 0;
    for(int i = 0; i < str.length(); i++) {

        if(i > 0 && last != str.charAt(i)) {
            sb.append(count + "" + last);
            last = 0;
            count = 1;
        }
        else {
            count++;
        }

        last = str.charAt(i);

    }
    sb.append(count + "" + last);
    return sb.toString();
}