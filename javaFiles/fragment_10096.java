public class B
{
    String val = "old";
}

public class InheritedB extends B {
    B other;

    public InheritedB(B other)
    {
        this.other = other;
    }

    void printVal() {
        System.out.println(val + " "+ other.val);
    }
}