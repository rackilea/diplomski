public static String addCommas(String num){
    StringBuilder sb = new StringBuilder();
    for(int i=num.length();i>0;i=i-3){
        if(i-3>0)
            sb.insert(0,"," + num.substring(i-3,i));
        else
            sb.insert(0, num.substring(0,i));
    }
    return sb.toString();
}