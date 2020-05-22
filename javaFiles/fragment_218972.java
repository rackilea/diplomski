public interface MyEntityRepo extends JpaRepository<MyEntity, Integer>, QuerydslPredicateExecutor<MyEntity>, QuerydslBinderCustomizer<QMyEntity> {
    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QMyEntity entity) {

        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);

        // Add 'between' and 'greater or equal' filter date property
        bindings.bind(entity.createdAt).all((path, value) -> {
            Iterator<? extends LocalDate> it = value.iterator();
            LocalDate from = it.next();
            if (value.size() >= 2) {
                LocalDate to = it.next();
                return Optional.of(path.between(from, to)); // between
            } else {
                return Optional.of(path.goe(from)); // greater than or equal
            }
        });
    }