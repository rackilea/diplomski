import org.mockito.Mockito;

class B {

    public static void main(String... args) {
        A mockedA = Mockito.mock(A.class);
        A realA = new A(mockedA);
        System.out.println(realA);
    }
}