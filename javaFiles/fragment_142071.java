@Component
@Order(2)
public class PlayingFieldByConfiguration implements CommandLineRunner {

    @Autowired
    private PlayerFactoryBean factoryBean;

    @Override
    public void run(String... arg0) throws Exception {
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Benedict");
        names.add("Chloe");

        System.out.println("Printing from component variant: ");
        names.forEach(n -> {
            try {
                factoryBean.setName(n);
                System.out.println(factoryBean.getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}