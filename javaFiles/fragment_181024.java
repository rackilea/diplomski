jlong java_some_class_jni_method(...)
{
    .... parse your text file ....
    MyParseclass* cls = new MyParseclass(...);
    ....
    return (jlong) cls;
}