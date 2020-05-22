final String code = "code";
final String name = "name";
final JPASubQuery subQuery = new JPASubQuery();
final QParent parent = QParent.parent;
final QChild child = QChild.child;
subQuery.from(child)
        .where(child.id.code.eq(code)
                .and(child.id.name.eq(name)));
predicateBuilder.or(parent.id.in(subQuery.list(child.id.parentId)));