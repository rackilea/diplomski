public class Invoice {        
    public void simpleMessage() {
        System.out.println("This is another class");
    }

    public static void main(String[] args) {
        Invoice invoiceObject = new Invoice();
        invoiceObject.simpleMessage();
    }
}