@Autowired EntityManagerFactory emf;

...

clientRepository.disableChange(22);
emf.getCache().evict(..., 22);