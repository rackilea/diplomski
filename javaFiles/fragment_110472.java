class MyUberspectImpl extends UberspectImpl {

    public MyUberspectImpl(Log jexlLog) {
        super(jexlLog);
    }

    @Override
    public JexlPropertyGet getPropertyGet(Object obj, Object identifier, JexlInfo info) {
        // for security we do not allow access to .class property
        if ("class".equals(identifier)) throw new RuntimeException("Access to getClass() method is not allowed");
        JexlPropertyGet propertyGet = super.getPropertyGet(obj, identifier, info);
        return propertyGet;
    }

    @Override
    public JexlMethod getMethod(Object obj, String method, Object[] args, JexlInfo info) {
        // for security we do not allow access to .getClass() method
        if ("getClass".equals(method)) throw new RuntimeException("Access to getClass() method is not allowed");
        return super.getMethod(obj, method, args, info);
    }

}