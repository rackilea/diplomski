public class CodePlay {

    public static void main(String[] args) {
        CodePlay cp = new CodePlay();
        System.out.println(cp.methodA(null));
    }

    public <T extends MyClass> T methodA(Class<T> clazz){
        // do stuff
        return methodB(clazz);
    }

    public <T extends MyClass> T methodB(Class<T> clazz) {
        // do stuff
        return null;
        // return actual value
    }

}

class MyClass {
    // do stuff
}