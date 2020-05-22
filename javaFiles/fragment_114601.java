private static <T extends IReader> Vector<T> Read(T obj)
{
    Vector<T> List = new Vector<T>(); // Create new Vector

    // Create new instance of the type T

    obj.myFunction();

    // Add to the Vector
    List.add(obj);

    // return Vector
    return List;
}