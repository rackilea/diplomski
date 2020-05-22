public class ExampleType<A extends Number>{
    public <T extends A> T[] bestMethod(T[] array)
    {
        if(array.length < testSize)
            array = (T[]) Array.newInstance(array.getClass().getComponentType(), testSize); //Type safety: Unchecked cast from Object to T[]
        System.out.println("in this case: "+array.getClass().getComponentType().getSimpleName());
        return array;
    }
}