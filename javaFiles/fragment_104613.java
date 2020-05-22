import java.util.ArrayList;
import java.util.List;

public class Foo {
    public static class Bar {
        public String sBar1, sBar2;

        public Bar(String sBar1, String sBar2) {
            this.sBar1 = sBar1;
            this.sBar2 = sBar2;
        }
    }

    String sFoo;
    List<Bar> bi;

    public Foo() {
        bi = new ArrayList<>();
    }

    public Foo(String sFoo, List<Bar> bi) {
        this.sFoo = sFoo;
        this.bi = bi;
    }

    public final void runFooBar(String sFoo, Bar... barArgs) {
        this.sFoo = sFoo;
        for (Bar x : barArgs) {
            System.out.println(x.sBar1 + ":" + x.sBar2);
        }
    }

    public static void main(String[] args) {
        Foo fi = new Foo();
        fi.runFooBar("foo 1", new Bar("1 sBar1", "1 sBar2"), new Bar("2 sBar1", "2 sBar2"));

    }//end main
}//end class