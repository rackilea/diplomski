public List<City> findCityAroundSelectedCity( double longitude, double latitude,
                                              float distance )
{
   // queryString should be a private static final, outside this method...
   return (List<City>) entityManager.createNativeQuery( queryString, City.class )
      .setParameter( "lat", latitude ).setParameter( "lng", longitude )
      .setParameter( "dis", distance ).getResultList();
}