public abstract class AbstractDIDOModel<T> 
{

 private Class<?> persistentClass = (Class<?>) ((ParameterizedType)  this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

 private T getInstance(final HashMap<String, String> data)
    {
        T retObj = null;
        try
        {
            Constructor ct = persistentClass.getDeclaredConstructor(HashMap.class);
            Object[] argList = new Object[1];
            argList[0] = data;
            retObj = (T) ct.newInstance(argList);
        } catch (Exception e)
        {
        }   // try
        return retObj;
    }