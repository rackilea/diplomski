import java.util.*; 
public class NumberReverse { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many numbers you want to place on the Stack: ");
        int stackSize = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < stackSize; i++){ 
            System.out.println("Enter numbers: "); 
            int number = sc.nextInt();  
            stack.push(number); 
        }
        while (!(stack.isEmpty())) { 
            System.out.println(stack.pop()); 
        } 
    } 
}