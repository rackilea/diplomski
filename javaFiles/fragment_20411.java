@Override
public List<Person> searchPersonsWithSimilarBooks(Long[] bookIds) {
    Criteria similarPersonCriteria = this.getSession().createCriteria(Person.class, "p");

    Criteria bookCriteria = similarPersonCriteria.createCriteria("ownedBooks", "b");
    bookCriteria.add(Restrictions.in("b.id", bookIds));

    similarPersonCriteria.setProjection(Projections.projectionList()
            .add(Projections.groupProperty("p.id"), "id")
            .add(Projections.rowCount(), "similarBookCount"));

    similarPersonCriteria.addOrder(Order.desc("similarBookCount"));
    similarPersonCriteria.setResultTransformer(new AliasToBeanResultTransformer(Person.class));

    return similarPersonCriteria.list();
}