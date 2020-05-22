static Object lookup(String clazzName, String parameters)
                                               throws ReflectiveOperationException {
    String[] args=parameters.split(",");
    int nArg=args.length;
    Class<?>[] argType=new Class<?>[nArg];
    Arrays.fill(argType, String.class);

    Class<?> clazz=Class.forName(clazzName);
    Lookup l=MethodHandles.lookup();
    MethodHandle handle;
    try {
        // if there is an exact match (without varargs), Java prefers that
        handle=l.findConstructor(clazz, MethodType.methodType(void.class, argType));
    } catch(NoSuchMethodException ex) {
        // we have to search all candidates, like Java we reject ambiguous methods
        Constructor<?> found=null;
        find: for(Constructor<?> c: clazz.getConstructors()) {
            if(!c.isVarArgs()) continue;
            Class<?>[] param = c.getParameterTypes();
            int nConcrete = param.length-1;
            if(nConcrete>nArg || param[nConcrete]!=String[].class) continue find;
            for(int ix=0; ix<nConcrete; ix++)
                if(param[ix]!=String.class) continue find;
            if(found!=null) throw new NoSuchMethodException(
                                             "ambiguous: "+found+" and "+c+" match");
            found=c;
        }
        handle=l.unreflectConstructor(found);
    }
    try {
        return handle.invokeWithArguments((Object[])args);
    } catch(Throwable ex) {
        throw new InvocationTargetException(ex);
    }
}