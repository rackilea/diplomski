public static void copyProperties(Object arg0, Object arg1) 
            throws IllegalAccessException, InvocationTargetException {
        java.util.Date defaultValue = null;
        Converter converter = new DateConverter(defaultValue);
        BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance(); 
        beanUtilsBean.getConvertUtils().register(converter, java.util.Date.class);
        beanUtilsBean.copyProperties(arg0, arg1);
    }