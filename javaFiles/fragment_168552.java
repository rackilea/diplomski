public static void main(String[] args) {
    String numbers = "5 1 5 1";
    String[] tokens = numbers.split("\\s+");
    for(String token:tokens){
        System.out.println(token);
    }
}