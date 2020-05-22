import java.util.Arrays;
public class IntegerStack 
{

    private int stack [];
    private int top; 

    public IntegerStack(int SIZE) 
   {
    stack = new int [SIZE];
    top = -1; // top should be 0. If you keep it as -1, problems will arise when SIZE is passed as 0. 
    // In your push method -1==0 will be false and your code will try to add the invalid element to Stack .. 
     /**Solution top=0; */
    }

public void push(int i) 
{
    if (top == stack.length)
    {
        extendStack();
    }

       stack[top]= i;
        top++;

}

public int pop() 
{
    top --; // here you are reducing the top before giving the Object back 
   /*Solution 
      if(!isEmpty()){
      int value = stack[top];
       top --;
     return value; 
    } else{
      return -1;// OR invalid value
    }
   */
    return stack[top];
}

public int peek()
{
    return stack[top]; // Problem when stack is empty or size is 0
    /*Solution 
       if(!isEmpty()){
         return stack[top];
       }else{
         return -1;// Or any invalid value
       }
    */


}


public boolean isEmpty() 
{
    if ( top == -1); // problem... we changed top to 0 above so here it need to check if its 0 and there should be no semicolon after the if statement
   /* Solution if(top==0) */
    {
        return true;
    }
}

private void extendStack()
{

    int [] copy = Arrays.copyOf(stack, stack.length); // The second parameter in Arrays.copyOf has no changes, so there will be no change in array length.
  /*Solution  
    stack=Arrays.copyOf(stack, stack.length+1); 
   */
     }

     }