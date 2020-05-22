Scanner scan = null;
try {
    File file = new File("C:\\Users\\Jason\\workspace\\EmpData");
    // Scanner scan = new Scanner(file);
    scan = new Scanner(file);
}catch(Exception e) {
    System.out.println(e.getMessage());
    System.exit(1);
}