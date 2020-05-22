@XStreamAlias("a")
public class A {

}

@XStreamAlias("b")
public class B extends A {

}

@XStreamAlias("c")
public class C {
    private ArrayList<A> aList = null;

    public C() {
        aList = new ArrayList<A>();
        aList.add(new A());
        aList.add(new B());
        aList.add(new A());
    }

    public static void main(String[] args) {
        C c = new C();

        XStream x = new XStream();
        x.processAnnotations(A.class);
        x.processAnnotations(B.class);
        x.processAnnotations(C.class);

        System.out.println(x.toXML(c));
    }

}