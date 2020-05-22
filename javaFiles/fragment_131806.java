public static Object calleableFromAnywhere(Object o) throws IllegalAccessException, InstantiationException {
    Object ret = null;
    if(!Objects.isNull(o)){
        ret = o.getClass().newInstance();
    }
    return ret;
}