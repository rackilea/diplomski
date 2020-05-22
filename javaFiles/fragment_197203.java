@Inject
BeanManager manager;

Set<Bean<?>> beans = manager.getBeans(Greeting.class, Named.class);

for (Bean<?> bean : beans) {
    String name = getQualifierOfType(bean.getQualifiers(), Named.class).value();
    map.put(name, greeting);
}

<Annotation, T extends Annotation> T getQualifierOfType(Set<Annotation> qualifiers, Class<T> type) {
    for (Annotation qualifier : qualifiers)
        if (type.isAssignableFrom(qualifier.getClass()))
            return type.cast(qualifier);

    return null;
}