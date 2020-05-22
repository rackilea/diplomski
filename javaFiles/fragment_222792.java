class Outer {
    int a = 100;

    public interface AnInterface {
        void mInner();  // automatically "public"
    } 

    AnInterface mOuter() {   // note that the return type is no longer Object
        class Inner implements AnInterface {
            @Override
            public void mInner() {    // must be public
                int y = 200;
                System.out.println("mInner..");
                System.out.println("y : " + y);
            }
        }
        Inner iob = new Inner();  
        return iob;
    }
}   

class Demo {
    public static void main(String[] args) {  // the preferred syntax
        Outer t = new Outer();
        Outer.AnInterface ob = t.mOuter();
        ob.mInner(); 
    }
}