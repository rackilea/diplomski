public class Test {
    private Test(T1 input) {
        // ...
    }

    private Test(T2 input) {
        // ...
    }

    public static Test createTest(Object input) {
       if (input instanceof T1)
          return new Test((T1) input);
       if (input instanceof T2)
          return new Test((T2) input);
        return null;
    }
}