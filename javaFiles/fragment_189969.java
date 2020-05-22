/**
 * {@inheritDoc}
 */
@Override
public List<Label> getAllLabels() throws Exception {
    TypedQuery<Label> typedQuery = em.createQuery(
            "SELECT x FROM Label x", Label.class );
    return typedQuery.getResultList();
}