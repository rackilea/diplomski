public class A<T>
{
    private Class<T> type;
    private long ptr; 

    public class A(Class<T> type)
    {
        this.type = type;
        ptr = create( getGenericType() ); 

        if(ptr == 0)
        {
            throw new NullPointerException(); 
        }
     }

    private String getGenericType()
    {
        return type.getName();
    }

    private native long create(String className); 
}