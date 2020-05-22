@Bean
InitializingBean createTestEntries(@Autowired EntityManager em) {
   return () -> {
     Query q = em.createNativeQuery("custom sql");
     q.executeUpdate()
   }
}