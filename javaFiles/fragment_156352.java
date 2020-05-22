@Repository
    //Transactional makes transaction automatical, so you do not have to begin and commit transactions yourself!
    @Transactional 
    public class BankAdminDao{

    //This makes your life a lot eaier!
    //It will take care of your EntitManagerFactory and Sessions
    @PersistenceContext
    EntityManager em;

    public void save(BankAdmin bank) {
        em.merge(bank);
    }

    //get lms lights config from DB
    public List<BankAdmin> getAllBankAdmin() {
         List<BankAdmin> bankList = (List<BankAdmin>)em.createQuery("SELECT b FROM BankAdmin b");
         return bankList;
    }

    public BankAdmin getBankAdmin(int bankId) {
        return em.find(BankAdmin.class, bankId);
    }
    }