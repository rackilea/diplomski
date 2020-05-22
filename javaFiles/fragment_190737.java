public class Test {

        public static void main(String[] args)
        {
            URLClassLoader loader = (URLClassLoader) Test.class.getClassLoader();

            System.out.println(Arrays.toString(loader.getURLs()));

            System.out.println(loader.getResource("foo/Test.class"));
        }
}