import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public final class SimpleSelectBuilder<E extends Entity> {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final CriteriaQuery<E> criteriaQuery;
    private final Root<E> root;
    private final Collection<Predicate> predicates;

    private Integer first = null;
    private Integer max = null;
    private LockModeType lockModeType = null;

    public SimpleSelectBuilder(final EntityManager entityManager, final Class<E> entityClazz) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
        this.criteriaQuery = this.criteriaBuilder.createQuery(entityClazz);
        this.root = criteriaQuery.from(entityClazz);
        this.predicates = new Vector<>();
    }

    public SimpleSelectBuilder<E> and(final Attribute attribute, final Object value) {
        final Expression expression = this.getExpression(attribute, root);
        this.predicates.add(criteriaBuilder.equal(expression, value));
        return this;
    }

    public SimpleSelectBuilder<E> andNotIn(final Attribute attribute, final Collection<Object> values) {
        final Expression expression = this.getExpression(attribute, root);
        this.predicates.add(criteriaBuilder.not(expression.in(values)));
        return this;
    }

    public SimpleSelectBuilder<E> andIn(final Attribute attribute, final Collection<Object> values) {
        final Expression expression = this.getExpression(attribute, root);
        this.predicates.add(expression.in(values));
        return this;
    }


    public SimpleSelectBuilder<E> andContains(final Attribute attribute, final Object value) {

        final Expression expression = this.getExpression(attribute, root);
        this.predicates.add(criteriaBuilder.isMember(value, expression));
        return this;
    }

    public SimpleSelectBuilder<E> orderByAsc(final Attribute attribute) {
        final List<Order> orders = new ArrayList<>();
        if (this.criteriaQuery.getOrderList() != null) {
            orders.addAll(this.criteriaQuery.getOrderList());
        }
        orders.add(criteriaBuilder.asc(this.getExpression(attribute, root)));
        this.criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));
        return this;
    }

    public SimpleSelectBuilder<E> orderByDesc(final Attribute attribute) {
        List<Order> orders = this.criteriaQuery.getOrderList();
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(criteriaBuilder.desc(this.getExpression(attribute, root)));
        this.criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));
        return this;
    }

    public SimpleSelectBuilder<E> setFirst(Integer first) {
        this.first = first;
        return this;
    }

    public SimpleSelectBuilder<E> setMax(Integer max) {
        this.max = max;
        return this;
    }

    public SimpleSelectBuilder<E> setLockModeType(LockModeType lockModeType) {
        this.lockModeType = lockModeType;
        return this;
    }

    public List<E> getResultList() {
        final TypedQuery<E> query = this.prepareQuery();

        if (lockModeType != null) {
            query.setLockMode(lockModeType);
        }

        if (first != null) {
            query.setFirstResult(first);
        }

        if (max != null) {
            query.setMaxResults(max);
        }

        return query.getResultList();
    }

    public List<E> getCacheableResultList() {
        final TypedQuery<E> query = this.prepareQuery();

        if (lockModeType != null) {
            query.setLockMode(lockModeType);
        }

        if (first != null) {
            query.setFirstResult(first);
        }

        if (max != null) {
            query.setMaxResults(max);
        }

        query.setHint("org.hibernate.cacheable", true);
        query.setHint("org.hibernate.cacheMode", "NORMAL");
        return query.getResultList();
    }

    public E getSingleResult() {
        final TypedQuery<E> query = this.prepareQuery();

        if (lockModeType != null) {
            query.setLockMode(lockModeType);
        }

        return query.getSingleResult();
    }

    public E getCacheableSingleResult() {
        final TypedQuery<E> query = this.prepareQuery();

        if (lockModeType != null) {
            query.setLockMode(lockModeType);
        }

        query.setHint("org.hibernate.cacheable", true);
        query.setHint("org.hibernate.cacheMode", "NORMAL");
        return query.getSingleResult();
    }

    private TypedQuery<E> prepareQuery() {
        this.criteriaQuery.where(this.predicates.toArray(new Predicate[this.predicates.size()]));
        return this.entityManager.createQuery(criteriaQuery);
    }

    private <T> Expression<T> getExpression(final Attribute attribute, final From<E, T> from) {
        if (attribute instanceof SingularAttribute) {
            SingularAttribute singularAttribute = (SingularAttribute) attribute;
            return from.get(singularAttribute);
        } else if (attribute instanceof PluralAttribute) {
            PluralAttribute pluralAttribute = (PluralAttribute) attribute;
            return from.get(pluralAttribute);
        } else {
            throw new PersistenceException("Attribute type of '" + attribute
                    + "' must be one of [SingularAttribute, PluralAttribute].");
        }
    }

    private <T> Join<E, T> getJoinExpression(final Attribute attribute, final From<E, T> from) {
        if (attribute instanceof SingularAttribute) {
            final SingularAttribute singularAttribute = (SingularAttribute) attribute;
            return from.join(singularAttribute);
        } else if (attribute instanceof CollectionAttribute) {
            final CollectionAttribute collectionAttribute = (CollectionAttribute) attribute;
            return from.join(collectionAttribute);
        } else {
            throw new PersistenceException("Attribute type of '" + attribute
                    + "' must be one of [SingularAttribute, PluralAttribute].");
        }
    }

    public SimpleSelectBuilder<E> joinAnd(final Attribute attribute, final Object value, final Attribute... joinOn) {
        Join tableJoin = null;
        for (final Attribute join : joinOn) {
            if (tableJoin == null) {
                tableJoin = this.getJoinExpression(join, root);
            } else {
                tableJoin = this.getJoinExpression(join, tableJoin);
            }

        }

        if (tableJoin == null) {
            throw new PersistenceException("SelectBuilder cannot construct your join statement");
        }

        final Expression expression = this.getExpression(attribute, tableJoin);
        this.predicates.add(criteriaBuilder.equal(expression, value));
        return this;
    }
}