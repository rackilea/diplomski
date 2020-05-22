public interface FuneralPricingRepository extends JpaRepository<FuneralPricing, Long> {


    Page<FuneralPricing> findByScenarioBetween(Long min, Long max, Pageable pageable);


}