JavaClass ext1(env, "ExceptionType1");
JavaClass ext2(env, "ExceptionType2");
JavaClass ext3(env, "ExceptionType3");

SomeMethod();

if (ex = env->ExceptionOccurred()) {
    if (ext1.isInstanceOf(ex)) {
        doSomething();
    } else if (ext2.isInstanceOf(ex)) {
        doSomething();
    } else if (ext3.isInstanceOf(ex)) {
        doSomething();
    }
}