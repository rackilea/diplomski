public class UpdateAction extends HibernateAction<Program> {

    public UpdateAction(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    protected Program action(EntityManager entityManager, Program entity) {
        return entityManager.merge(entity);
    }
}