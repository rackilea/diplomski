public <T, K, P> List<T> GetList(Class<T> arg1, Class<K> arg2, Class<P> arg3)
{
    // build an xml string according to the given types, methods and properties
    string request = BuildRequestXml(arg1, arg2, arg3);

    // invoke the remote service and get the xml result
    string response = Invoke(request);

    // deserialize the xml to the object
    return Deserialize<T>(response);
}