List<BaseClass> list = getSomeBaseClasses();

Map<Class<? extends BaseClass>, List<BaseClass> map = list.stream()
    .collect(Collectors.groupingBy(BaseClass::getClass));

map.forEach((aClass, bases) -> {
    SomeImpl<BaseClass> impl = getBaseImpl(aClass);
    impls.forEach(impl::execute);
}