public class MatcherTest {

    class MyClass{
        private String status;

        MyClass(String status) {
            this.status = status;
        }

        public String getStatus(){
            return status;
        }
    }

    class MyDao {
        public void update(MyClass myClass){}
    }

    class StatusMatcher extends ArgumentMatcher<MyClass> {
        private String status;
        public StatusMatcher(String hs) {
            status = hs;
        }

        @Override
        public boolean matches(Object argument) {
            return status.equals(((MyClass)argument).getStatus());
        }
    }

    @Test
    public void shouldMatchStatus(){
        MyDao mock = mock(MyDao.class);
        mock.update(new MyClass("expectedStatus"));
        verify(mock, times(1)).update(argThat(new StatusMatcher("expectedStatus")));
    }

    @Test
    public void shouldNotMatchStatus(){
        MyDao mock = mock(MyDao.class);
        mock.update(new MyClass("unexpectedStatus"));
        /* THE BELLOW WILL FAIL BECAUSE ARGUMENTS ARE DIFFERENT */
        verify(mock, times(1)).update(argThat(new StatusMatcher("expectedStatus")));
    }
}