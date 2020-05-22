@Autowired
private TestEntityManager testEntityManager;

@Autowired
PlatformTransactionManager transactionManager;

@BeforeTransaction
public void setUp() {
    new TransactionTemplate(transactionManager).execute(status -> {
        UserAccount owner = testEntityManager.persist(createUserAccount(OWNER_OF_ADVERTISEMENT_EMAIL));
        Language language = testEntityManager.persist(createLanguage("Français"));
        DayToTimeSlot dayToTimeSlot = testEntityManager.persist(createDayToTimeSlot());

        advertisement = testEntityManager.persist(createAdvertisement(owner, language, dayToTimeSlot));
        impersonator = testEntityManager.persist(createUserAccount(IMPERSONATOR_EMAIL));

        return null;
    });
}

@AfterTransaction
public void tearDown() {
    new TransactionTemplate(transactionManager).execute(status -> {
        testEntityManager.remove(testEntityManager.find(Advertisement.class, advertisement.getId()));

        UserAccount owner = advertisement.getUserAccount();
        testEntityManager.remove(testEntityManager.find(UserAccount.class, owner.getId()));

        testEntityManager.remove(testEntityManager.find(UserAccount.class, impersonator.getId()));

        return null;
    });
}