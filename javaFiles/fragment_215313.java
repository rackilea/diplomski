public static void recurse(String str){
    if(str.length() > 0) {
        System.out.print(str.charAt(str.length()-1));
        System.out.print(str.charAt(str.length()-1));
        recurse(str.substring(0, str.length() - 1));
    }
}