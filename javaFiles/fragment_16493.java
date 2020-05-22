@Repository
public TweetpostRepository extends CrudRepository<Tweetpost , Integer>{

    @Query("select t.id from TweetPost t order by t.date desc")
    public Page<Integer> findLatestId(Pageable pageable);

    @Modifying
    @Transactional
    @Query("delete from TweetPost t where t.id not in (:idList)")
    public void deleteByExcludedId(@Param("idList") List<Integer> idList);

    ...
}