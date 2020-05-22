import com.plug.abc;
public class xyz
{
    private abc object;
    public void callNonStatic() {
        //lines to initiate logs
        if(object==null)
            //prints Object is null, assuming object is created as part of constructor or any other method
        else
            object.nonStaticMethod();
    }
    public void callStatic() {
        //an optional way and not encouraged
        if(object==null)
            //prints Object is null, assuming object is created as part of constructor or any other method
        else
            // this will work with compile time warning
            object.staticMethod();

        // Ideal way of calling a static method
        abc.staticMethod();
    }
}