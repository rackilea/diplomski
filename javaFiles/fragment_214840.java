public static void copyProperties(Object src, Object trg, Iterable<String> props) {

    BeanWrapper srcWrap = PropertyAccessorFactory.forBeanPropertyAccess(src);
    BeanWrapper trgWrap = PropertyAccessorFactory.forBeanPropertyAccess(trg);

    props.forEach(p -> trgWrap.setPropertyValue(p, srcWrap.getPropertyValue(p)));

}