public static boolean test(String s){
    try{
        Integer i = Integer.parseInt(s);
        return true;
    }catch(Exception e){
        return false;
    }
}