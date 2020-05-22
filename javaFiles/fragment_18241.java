Exception in thread "main" java.lang.IllegalAccessException: Can not set static final [Lplayground.Color; field playground.Color.ENUM$VALUES to [Lplayground.Color;
    at sun.reflect.UnsafeFieldAccessorImpl.throwFinalFieldIllegalAccessException(UnsafeFieldAccessorImpl.java:76)
    at sun.reflect.UnsafeFieldAccessorImpl.throwFinalFieldIllegalAccessException(UnsafeFieldAccessorImpl.java:80)
    at sun.reflect.UnsafeQualifiedStaticObjectFieldAccessorImpl.set(UnsafeQualifiedStaticObjectFieldAccessorImpl.java:77)
    at java.lang.reflect.Field.set(Field.java:758)
    at playground.ReflectEnum.setEnumsArray(ReflectEnum.java:76)
    at playground.ReflectEnum.main(ReflectEnum.java:37)