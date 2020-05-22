public void Action1(){
    BeanUtilsBean beanUtils = new BeanUtilsBean();
    ConvertUtilsBean convertUtils = beanUtils.getConvertUtils();
    DateTimeConverter dtConverter = new DateConverter();
    dtConverter.setPatterns(dateFormats1);
    convertUtils.register(dtConverter, Date.class);
    ...
    beanUtils.populate(myBean1, hashMap1);
}