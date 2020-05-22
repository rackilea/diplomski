public class MyStatement implements HasSomeMethod
{
    PreparedStatement stmt;

    public MyStatement (PreparedStatement stmt) {
         this.stmt = stmt;
    }

    public void someMethod ()
    {
        stmt.someMethod ();
    }
}