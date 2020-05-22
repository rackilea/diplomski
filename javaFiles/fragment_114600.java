private static <T extends IReader> Vector<T> Read(Class<T> cl)
{
    Vector<T> List = new Vector<T>(); // Create new Vector

    // Create new instance of the type T
    T Dataset = cl.newInstance();
    Dataset.myFunction();

    // Add to the Vector
    List.add(Dataset);

    // return Vector
    return List;
}