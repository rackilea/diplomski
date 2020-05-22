// PrintAndEmpty 'this' stack.
public void PrintAndEmpty()
{
   // The condition to check - e.g. 'this' stack.
   while(!this.empty()) {
       // Pop from the stack - e.g. 'this' stack.
       System.out.println(this.pop().getName());
   }
}