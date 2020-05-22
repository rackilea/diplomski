public class MyClass<SomeType>
{
    //...
    public void a(SomeType st)
    {
        if (SomeType extendsOrIs MyClass<?>) // Need help with this line
        {
            MyClass<?> mc = (MyClass<?>) st;
            mc.b();
        }
    }
   public final boolean isSubClass()
   {    
     if(this.getClass()!=MyClass.class){
     return true;
     }
    return false;
   }

public void a(SomeType st)
    {
        if (st instanceof MyClass<?>)
        {
            MyClass<?> mc = (MyClass<?>) st;
            mc.isSubClass();
        }
    }