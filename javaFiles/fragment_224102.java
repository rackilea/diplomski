public static void main(String[] args) {

    String s ="5\":\"6789\":\"78";
    String[] arr = s.split("\\D+");// \\D+ splits the string based on one or more non-numeric characters.
    for(String str :arr){
        System.out.println(str);
    }
}