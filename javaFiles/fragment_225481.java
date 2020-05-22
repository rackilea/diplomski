public class X
{
    private int x = 1;

    //some other code here

    public void setX(int proposedValueForX)
    {
       if(proposedValueForX != x)
       {
           doOneTimeTaskIfVariableHasChanged();
           x = proposedValueForX;
       }
    }
}