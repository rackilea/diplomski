public interface OfferRepository extends JpaRepository<Offer, Long> {

    default List<Offer> findAllWhereOfferStateIsActive() {
        return findByOfferState(OfferState.ACTIVE);
    }

    List<Offer> findByOfferState(OfferState state);
}