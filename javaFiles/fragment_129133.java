public class Test3 {

    public static void main(String[] args) {

        Class<?> actualMainClassTest = LauncherHelper.checkAndLoadMain(true, 1, Test.class.getName());
        Class<?> actualMainClassTest2 = LauncherHelper.checkAndLoadMain(true, 1, Test2.class.getName());

        System.out.println("Actual loaded main class for Test: " + actualMainClassTest.getName());
        System.out.println("Actual loaded main class for Test2: " + actualMainClassTest2.getName());
    }
}