public List<NeedNode> getRootsByTree(NeedsTreev2 tree) {
    List<NeedNode> ret;

    CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
    CriteriaQuery<NeedNode> cq = cb.createQuery(NeedNode.class);

    Root<NeedNode> nNode = cq.from(NeedNode.class);

    Subquery<Long> sq = cq.subquery(Long.class);
    Root<NeedLink> nLink = sq.from(NeedLink.class);
    Join<NeedLink, NeedNode> d = nLink.join(NeedLink_.descendant, JoinType.INNER);
    sq.where(cb.notEqual(nLink.get(NeedLink_.ancestor), nLink.get(NeedLink_.descendant)));
    sq.select(d.get(NeedNode_.id));
    sq.distinct(true);

    Predicate[] p = {
        cb.equal(nNode.get(NeedNode_.needsTree), tree),
        nNode.get(NeedNode_.id).in(sq).not()
    };

    cq.where(cb.and(p));

    TypedQuery<NeedNode> query = this.getEntityManager().createQuery(cq);
    ret = query.getResultList();

    return (ret);
}