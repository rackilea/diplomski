@Repository
    @Transactional
    public class CardsDao{

        @PersistenceContext
        EntityManager em;

        @Autowired
        BankAdminDao bad;

        public void save(Card cards, int bankId) {
            BankAdmin bank = bad.getBankAdmin(bankId);
            cards.setBankAdmin(bank);   
            bank.getCards().add(cards);
            em.merge(bank);
        }

        public List<Card> getAllCards() {
            List<Card> cardList = (List<Card>)em.createQuery("SELECT c FROM Cards c");
             return cardList;
        }

        public Card getCard(int cardId){
            return em.find(Card.class, cardId);
        }
    }