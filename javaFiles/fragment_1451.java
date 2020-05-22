public class Foo {

    public static void main(String[] args) throws Exception {

        Testing test1 = new Testing();
        test1.setName("myName");
        test1.setSubject("mySubject");

        Testing test2 = test1.copy();
        test2.setName("newName");
        test2.setSubject("newSubject");

        System.out.println(String.format(
            "Printing test1\n%s\n\nPrinting test2\n%s",
            test1.asString(),
            test2.asString()
        ));
    }
}