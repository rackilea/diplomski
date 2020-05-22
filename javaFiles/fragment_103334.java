@Component
public class Auditorium {
    private static final Logger log = LoggerFactory.getLogger(Auditorium.class);
    private Integer id;
    private String name;
    private Integer numberOfSeats;
    private List<String> vipSeats;

    @Autowired
    public Auditorium(@Value("${auditorium1.name}") String name,
                      @Value("${auditorium1.number-of-seats}") Integer numberOfSeats,
                      @Value("${auditorium1.vip-seats}") List<String> vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
        log.debug(this.toString());
    }
}