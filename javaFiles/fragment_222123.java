fun throwsAJavaCheckedException(proxy:Any, method:Method, args:Array<Any>?): Any? {
    throw IOException();
}

typealias Invocation = (Any, Method, Array<Any>?) -> Any?;

fun <T:Any> KClass<T>.proxying(handler:Invocation) = cast(Proxy.newProxyInstance(
        ClassLoader.getSystemClassLoader(),
        arrayOf(java),
        handler
));