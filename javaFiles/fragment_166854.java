public boolean find(BinaryNode p,int x)
{
    boolean returnValue = false;
    if(p!=null)
    {
        if(x==p.element){
            returnValue = true;

        }       
        else if(x<p.element){
            returnValue = find(p.left,x);
        }
        else {
            returnValue = find(p.right,x);
        }
    }
    return returnValue;
}