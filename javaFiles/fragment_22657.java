import java.reflect.Array;

...

public static <T> T[][] to2DArray(Class<T> klazz, Collection<T>... collections)
{
    T[][] array = (T[][]) Array.newInstance(klazz, collections.length,
                                                   collections[0].size());
    //...
        array[i] = (T[]) Array.newInstance(klazz, collections[i].size());
    return array;
}