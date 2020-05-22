class SomeClass extends XYZ
{
    ParentActivity parent;        

    SomeClass(ParentActivity p)   //Constructor
    {
       this.parent = p;
       ......
    }

    public void someMethodWhereParentAccessIsRequired()
    {
        .....
        parent.doSomethingOnSomeTextView();
        ....
    }

}