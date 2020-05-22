public List<Car> findAllCarByBrandAndColor(String aBrand, String aColor)
{
    List<Car> theCars;

    Query theQuery = em.createNamedQuery("Car.findByBrandAndColor");
    theQuery.setParameter("brand", aBrand);
    theQuery.setParameter("color", aColor);

    try
    {
        theCars = (List<Car>) query.getResultList();
    }
    catch(NoResultException ex)
    {
        theCars = null;
    }

    return theCars;
}