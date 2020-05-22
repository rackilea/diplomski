public class EntityChainForceUpdateHibernateInterceptor extends EmptyInterceptor {

    @Override
    public void preFlush(Iterator entities) {
        entities.forEachRemaining(e -> {
            if (BaseEntity.class.isAssignableFrom(e.getClass())) {
                BaseEntity b = (BaseEntity) e;
                b.getParent().ifPresent(p -> p.updateChain());
            }
        });
    }
}