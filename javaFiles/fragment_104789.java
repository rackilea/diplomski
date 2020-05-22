public class ParentA
{
...    
public void addChildB(B pChild)
{
    this.childsB.add(pChild);
    pChild.setParentA( this );
}    
...
}