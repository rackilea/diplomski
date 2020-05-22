@Service
public class AccountService {

   @Autowired
   private AccountDao dao;

   @Transactional
   public void makePayment(Long fromId, Long toId, double amount) {
      Account from = dao.find(fromId);
      from.withdrawl(amount);

      Account to = dao.find(toId);
      to.deposit(amount);

      dao.save(from);
      dao.save(to);
   }
}