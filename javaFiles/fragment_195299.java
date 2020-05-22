public Object populate(Object obj, HashMap<String, String[]> formData)
            throws IllegalAccessException, InvocationTargetException {
        ConvertUtils
                .register(new StringToDateConverter(), java.util.Date.class);
        BeanUtilsBean.getInstance().populate(obj, formData);
        return obj;
    }