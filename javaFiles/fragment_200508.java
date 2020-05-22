@Repository
public interface OffersRepository extends CrudRepository<Offers, String> {

    List<Offers> findByStatus(String Status);

    Offers findByMsisdn(String Msisdn);
}