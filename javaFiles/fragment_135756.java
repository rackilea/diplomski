Scanner sc = new Scanner(System.in);
try{
    int a = sc.nextInt();
}catch(java.util.InputMismatchException e) {
        System.out.println("Invalid file content");
}