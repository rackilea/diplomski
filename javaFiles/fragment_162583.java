public interface AwardsRegionsRepository extends JpaRepository<AwardRegion,AwardRegionPk>{

    List<AwardRegion> findAllByOrderByAwardRegionPk_RegionAscSortKeyAsc();
    List<AwardRegion> findByAwardRegionPk_RegionOrderBySortKeyAsc(String region);

    @Query("select a.awardRegionPk.region, a.winnerCount from AwardRegion a "
            + "where a.awardRegionPk.awardId = :awardId order by a.awardRegionPk.region")
    List<AwardRegion> findByAwardRegionPk_AwardId(@Param("awardId") Long awardId);

}