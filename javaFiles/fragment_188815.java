class Client{

    private OuterClass outerClass;

    public OuterClass getOuterClass() {
        return outerClass;
    }

    public void setOuterClass(OuterClass outerClass) {
        this.outerClass = outerClass;
    }

    public void x(){
        System.out.println("===");
    }
    public void lucian() {
        OuterClass outerClass = new OuterClass();
        setOuterClass(outerClass);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(){
            void test() {
                Client1.this.x();
                x();
                System.out.println(getOuterClass());
            }
        };
        innerClass.test();
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.lucian();
    }