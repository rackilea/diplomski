@Repository
public interface SellerGeolocationRepository extends CrudRepository<Seller_Geolocation, Long> {

    @Query(value="SELECT * FROM seller_geolocation_ms WHERE ST_DWithin(cast(seller_geolocation_ms.location as geography),ST_SetSRID(ST_Point(?2, ?1),4326), 10000);", nativeQuery = true)
    public Set<Seller_Geolocation> findAllSellersInRange(double longitude, double latitude);

}