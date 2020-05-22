public class UsuarioRevisionListener implements RevisionListener, EntityTrackingRevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
    }

    @Override
    public void entityChanged(Class entityClass, String entityName, Serializable entityId, RevisionType revisionType, Object revisionEntity) {
        UsuarioRevisionEntity revision = (UsuarioRevisionEntity) revisionEntity;
        revision.getEntityRevType().put(UsuarioRevisionEntity.chave(entityClass,entityId), revisionType);
    }
}