public static class MyResult
{
    private String prop1;
    public void setProp1(String s)
    {
        ...
    }
}

...

public MyResult getResult(String script)
{
    //ugly-but-fast-to-code unchecked cast
    ScriptObjectMirror som = (ScriptObjectMirror) engine.eval(script);    
    MyResult myResult = new MyResult();
    BeanUtils.populate(myResult, som);
    return myResult;
}