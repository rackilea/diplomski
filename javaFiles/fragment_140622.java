import java.util.*;

public class StackSort
{
    static Stack<Double> A = new Stack<Double>();

    public void createStackA()
    {
        double[] x = {-10,5, 2, 1, 9, 0, 10};
        for (int i = 0; i < x.length; i++)
        {
            A.push(x[i]);
        }
    }

    public void sortStackA(Stack<Double> C)
    {
        Stack<Double> B = new Stack<Double>();

        while(!C.isEmpty())
        {
            double s1 = (double) C.pop();

            while(!B.isEmpty() && (B.peek() > s1))
            {
                C.push(B.pop());
            }
            B.push(s1);
        }

        System.out.println(B);
    }

    public static void main(String[] args) 
    {
        StackSort sS = new StackSort();
        sS.createStackA();
        sS.sortStackA(A);
    }
}