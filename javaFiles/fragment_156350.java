@SpringBootApplication
    public class StackoverflowApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(StackoverflowApplication.class, args);

        //Calling a class that is only made with the purpose of testing
        Verification ts = ctx.getBean(Verification.class);
        ts.run();
    }
    }

    @Component
    class Verification{

    @Autowired
    private BankAdminDao bad;

    @Autowired
    private CardsDao cd;

    void run(){
        //Create a new BankAdmin
        BankAdmin ba = new BankAdmin();
        ba.setAddress("someStreet");
        ba.setPhno(12341234);
        ba.setBname("myBanker");

        //Create two cards and add them to a HashSet.
        Card c1 = new Card("Visa", 1000, 1999, "Alot of", "Babes", ba);
        Card c2 = new Card("Master Card", 2000, 500, "someThing", "anotherThing", ba);
        Set<Card> cardList = new HashSet<>();
        cardList.add(c1);
        cardList.add(c2);

        //Create a associatio between the BankAdmin and list of Cards
        ba.setCards(cardList);

        //Save them to the database.
        bad.save(ba);

        //Here we add a Card to an existing BankAdmin with the id 6 in the database.

        //Create a new Card.
        //The BankAdmin is set to null, because we not have not yet loaded the BankAdmin
        Card c3 = new Card("Visa", 9999, 1337, "Alot of", "Male Babes", null);

        //Save Card c3 with the BankAdmin id 6
        cd.save(c3, 6);

    }
    }