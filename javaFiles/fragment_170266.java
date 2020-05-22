public class A {
    private final String name;

    public A(String name) {
        this.name= name;
    }

    public String sayHello() {
        return "Hi " + this.name;
    }}

@RunWith(PowerMockRunner.class)
@PrepareForTest(A.class)
public class MockA {

    @Test
    public void testSayHello throws Throwable {
         A a = mock(A.class); 
         when(a.sayHello()).thenReturn("Hi PowerMockito");
         PowerMockito.whenNew(A.class).withArguments(Mockito.anyString()).thenReturn(a);
         assertThat(new A("I am mockcked").sayHello(), equalTo("Yes, you are!"));
    }
}