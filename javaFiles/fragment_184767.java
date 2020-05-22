public abstract class TopMost {

    public TopMost(TopMost rhs) {

    }

}

public abstract class Top extends TopMost {

    public Top(Top rhs) {
        super(rhs);

        //whatever you need from rhs that only is visible from top
    }
}

public abstract class A extends Top { 

    public A (A rhs) {
        super(rhs);

        //TODO: do rhs copy
    }
}

public class ASub extends A {

    public ASub(ASub rhs) {
        super(rhs);

        //TODO: copy other stuff here....
    }

    public Object clone() {
        return new ASub(this);
    }
}