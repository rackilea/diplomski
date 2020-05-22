import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    import beans.*;
    import java.util.List;

    public class Facade {

        private SessionFactory sf = new Configuration().configure()
                .buildSessionFactory();
        private static ApplicationContext contxt;

        private BankDAO bankDAO;

        public static void getContext() {
            contxt = new ClassPathXmlApplicationContext("beans.xml");
        }

        public void createAccount(AccountDAO account) {
            contxt.getBean(AccountDAO.class).insert(account);
            System.out.println("Event was inserted");
        }

        public List<Account> getAllAccounts() {
            return contxt.getBean(AccountDAO.class).getAll();
        }

        public BankDAO getBankDAO() {
            return bankDAO;
        }

        public void setBankDAO(BankDAO bankDAO) {
            this.bankDAO = bankDAO;
        }
    }