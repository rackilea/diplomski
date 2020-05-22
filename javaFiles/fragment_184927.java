[SoapRpcMethod("", RequestNamespace="http://some.service.provider",
        ResponseNamespace="http://some.service.provider")]
    [return : SoapElement("getFooReturn")]
    [LongArrayHelper]
    public Foo getFoo()
    {
        object[] results = Invoke("getFoo", new object[0]);
        return ((Foo) (results[0]));
    }