public static boolean work(String str, char ch){
    //base case 
    if (str == null || str.equals("")){
        return false; 
    }

    //recursive case
    if (ch == str.charAt(0)){
        return true; 
    }else {
        return work(str.substring(1), ch); 
    }
}