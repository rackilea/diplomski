public class Test {
    public static void main(String[] args) {
        System.out.println(MyEnum.ONE.val);
    }

    public String one() {
        return "hello";
    }
    public String two() {
        return "world" ;
    }

    static Test instance;
    public synchronized static Test getInstance() {
        if (instance == null)
            instance = new Test();
        return instance;
    }
}