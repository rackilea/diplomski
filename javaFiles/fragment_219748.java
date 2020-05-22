/**
 * Return an instance of CriteriaBuilder for the creation of
 * CriteriaQuery objects.
 * @return CriteriaBuilder instance
 * @throws IllegalStateException if the entity manager has
 *         been closed
 */
public CriteriaBuilder getCriteriaBuilder();