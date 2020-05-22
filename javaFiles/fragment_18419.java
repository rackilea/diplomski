@Override
public E findByName(String name) {
    E entity = null;
    try {
        return (E)entityManager.createNamedQuery(myClass.getSimpleName() + ".findByName")
                               .setParameter("name", name)
                               .getSingleResult();
    } catch (Exception ex) {
        return null;
    }
}