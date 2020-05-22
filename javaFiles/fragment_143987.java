public class CriteriaContainer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Criteria criteria = null;
    private DetachedCriteria detachedCriteria = null;

    public CriteriaContainer(Criteria criteria) {
        this.criteria = criteria;
        this.detachedCriteria = null;
    }

    public CriteriaContainer(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
        this.criteria = null;
    }

    /**
     * @param eq
     * @return 
     */
    public CriteriaContainer add(final Criterion eq) {
        if (criteria != null) {
            criteria.add(eq);
        } else if (detachedCriteria != null) {
            detachedCriteria.add(eq);
        }
        return this;
    }

    /**
     * @return the criteria
     */
    public Criteria getCriteria() {
        return criteria;
    }

    /**
     * @return the detachedCriteria
     */
    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    /**
     * @param associationPath
     * @param alias
     * @return 
     */
    public CriteriaContainer createAlias(final String associationPath, final String alias) {
        if (criteria != null) {
            criteria.createAlias(associationPath, alias);
        } else if (detachedCriteria != null) {
            detachedCriteria.createAlias(associationPath, alias);
        }
        return this;
    }

    /**
     * @param distinctRootEntity
     * @return 
     */
    public CriteriaContainer setResultTransformer(final ResultTransformer transformer) {
        if (criteria != null) {
            criteria.setResultTransformer(transformer);
        } else if (detachedCriteria != null) {
            detachedCriteria.setResultTransformer(transformer);
        }
        return this;
    }
}

criteria = addBasicCriteria(new CriteriaContainer(criteria), ...).getCriteria()
detachedCriteria = addBasicCriteria(new CriteriaContainer(detachedCriteria), ...).getDetachedCriteria()