void java_some_calls_jni_method(..., jlong clsPtr)
{
    MyParseclass* cls = (MyParseclass*)clsPtr;
    ... do maybe do something with cls and access the data...
    delete cls; // do not use the jlong again in any call
}