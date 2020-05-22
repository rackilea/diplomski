class CustomizedPerGameStatsRepositoryImpl implements CustomizedPerGameStatsRepository { // name has to be ...Impl

  private final EntityManager em;

  @Autowired
  public CustomizedPerGameStatsRepositoryImpl(JpaContext context) {
    this.em = context.getEntityManagerByManagedType(PerGameStats.class);
  }

  public BigDecimal findMaxAmountOfField(String fieldName) {
    return (BigDecimal) em.createQuery("SELECT MAX(" + fieldName + ") FROM PerGameStats stats WHERE stats.gamesPlayed >= 10")
      .getSingleResult();
  }
}