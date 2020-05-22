final String name = "name";
final QParent parent = QParent.parent;
final QChild child = QChild.child;
final BooleanExpression newExpression  = BooleanTemplate.create("sim({0}, {1})",
        child.id.name, ConstantImpl.create(name));
final JPASubQuery subQuery = new JPASubQuery();
subQuery.from(child)
        .where(newExpression.isTrue());
predicateBuilder.or(parent.id.in(subQuery.list(child.id.parentId)));