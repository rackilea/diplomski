protected T uniqueResult (final String fieldName, final Object value) {
    return container().query(
        new Predicate<T>(getPredicateClass()) {
            private static final long   serialVersionUID    = 1L;
            public boolean match(T bean) {
                Object result = BeanUtils.getPropertyValue(bean, fieldName);
                return result == null ? null : result.equals(value);
            }
        }
    ).next();
}