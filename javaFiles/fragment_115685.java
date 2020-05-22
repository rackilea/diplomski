public class Test {
    public static void main(String[] args) {
        System.out.println(new TestA() { 
            public String toString(){ 
                return "test1"; 
            } 
        });
    }
}

public class Test2 {
    public static void main(String[] args) {
        System.out.println(new TestA() { 
            public String toString(){ 
                return "test2"; 
            } 
        });
    }
}