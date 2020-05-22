import java.util.Scanner;
public class Client{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Server.tableMaker();
        Server.printTable();
        System.out.println();
        Server.tossPenny();
        Server.printTable();
        input.close();
    }
}