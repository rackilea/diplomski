import java.util.Scanner;

public class Task{
    private int id;
    private String keyword;
    private double price;

    public void taskInput(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the id: ");
        id = scan.nextInt();

        System.out.println("\nEnter the keyword: ");
        keyword = scan.nextLine();

        System.out.println("\nEnter the price: ");
        price = scan.nextDouble();
    }

    public void taskOutput() {
        // Note that id, keyword and price are now members       
        System.out.println(id);
        System.out.println(keyword);
        System.out.println(price);
    }

    public static void main(String[] args){
        Task taskObject = new Task();

        taskObject.taskInput();
        taskObject.taskOutput();
    }
}