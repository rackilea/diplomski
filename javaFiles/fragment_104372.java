public static void main(String[] args) throws IOException {
    List<String> data = readFile();         
    Scanner sc = new Scanner(System.in);        
    System.out.println("Enter range");      
    long num1 = sc.nextLong();      
    long num2 = sc.nextLong();      
    writeFile(data, num1, num2);
    sc.close();     
}