public static void main(String[] args) throws Exception {
    String data = "ZZZ-1234567890-from ABC-2 DEF";
    String[] split = data.split("ZZZ-\\d+-");
    System.out.println(split[0]); 
    System.out.println(split[1]); 
}