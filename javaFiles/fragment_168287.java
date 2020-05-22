public List<Car> findCar(CarSearchFilter filter) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Car> c = cb.createQuery(Car.class);
    Root<Car> d = c.from(Car.class);

    // you have to add more predicates when you want more parameters
    List<Predicate> predicates = new ArrayList<Predicate>();
    if (filter.getName() != null) {
        predicates.add(cb.like(d.get(Car_.name), filter.getName()));
    }
    if (filter.getDate() != null) {
        predicates.add(cb.lessThanOrEqualTo(d.get(Car_.date), filter.getDate()));
    }

    c.select(d).where(predicates.toArray(new Predicate[] {}));
    TypedQuery<Car> q = em.createQuery(c);
    List<Car> results = q.getResultList();

    return results;
}