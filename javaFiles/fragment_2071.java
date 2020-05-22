public static <B extends Bean> mergeBeans(
        BeanCounter<B> des,
        BeanCounter<? extends B> src
) {
    for (B bean : src.getBeans()) {
        des.addBean(bean);
    }
}