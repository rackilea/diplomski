public static void main(String[] args) {
    if(args.length != 2){
        // crash the application with an error message
        throw new IllegalArgumentException("Please enter $filePath and $wordToFind as input parameters");
    }
    String filePath = args[0];
    String mot = args[1];
    System.out.println("filePath : "+filePath);
    System.out.println("mot : "+mot);
}