import java.util.List;
import java.util.ArrayList;
public class IntegerStack 

{

    private List<Integer> stack;

    public IntegerStack(int SIZE) 
    {
        stack = new ArrayList<Integer>(SIZE);
    }

    public void push(int i) 
    {

       stack.add(0,i);
     }

     public int pop() 
     { 
        if(!stack.isEmpty()){
           int i= stack.get(0);
           stack.remove(0);
           return i;
        } else{
           return -1;// Or any invalid value
        }
     }

     public int peek()
     {
        if(!stack.isEmpty()){
           return stack.get(0);
        } else{
           return -1;// Or any invalid value
        }
     }


     public boolean isEmpty() 
     {
       stack.isEmpty();
     }

 }