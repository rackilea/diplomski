public static void getSales() {
    try (
        Scanner input = new Scanner(System.in); // try-with-resources
    ) {
        int size = monthArray.length; 
        for (int i = 0; i < size; i++){
            System.out.print("Please Enter Sales for " + monthArray[i] + ":");
            monthlySales[i] = input.nextDouble();
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}

public static void main(String[] args) {
    getSales();
}