public class MyCreator { 
    Class kind; // this will be String.class at runtime

    MyCreator(Class kind) {
        this.kind = kind; 
    }

    void printInstanceClass() throws Exception{ 
        System.out.println(kind.newInstance().getClass());
    }

    public static void main(String[] args) throws Exception{ 
        MyCreator myCreator = new MyCreator(String.class);

        myCreator.printInstanceClass();
    } 
}