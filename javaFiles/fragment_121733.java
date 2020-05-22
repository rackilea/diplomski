public class Update
{
    public void visit(A obj) { /* generic */ }
    public void visit(B obj) { /* specific for B */ }
    public void visit(C obj) { /* specific for C */ }
}

public class A 
{
    public void accept(Update u) 
    {
        u.visit(this);
    }
}

public class B extends A {
    public void accept(Update u) 
    {
        u.visit(this);
    }
}

public class C extends A { 
    public void accept(Update u) 
    {
        u.visit(this);
    }
}