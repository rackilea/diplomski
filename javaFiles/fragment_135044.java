class Out {

    class Inner {
            void print() {
                System.out.println("i anm inner1");
            }
    }

    public Inner createInner(){
        return new Inner();
    }

    public void run() {
        Inner in = createInner();
        in.print();
    }

}

class Out2 extends Out {

    class Inner extends Out.Inner {
            void print() {
                System.out.println("i anm inner2");
            }

    }

    public Out.Inner createInner(){
        return new Inner();
    }
}