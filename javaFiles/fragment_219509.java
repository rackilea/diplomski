public class MyClass<T extends Message> 
{
    private Class<T> type;

    public MyClass(Class<T> type) { this.type = type; } 

    public Integer test(T m)                          
    {                                                 
       return type.test(m);                               
    }   

}