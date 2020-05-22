@Component(value="kenny")
public class Instrumentalist implements Performer
{
    @Autowired
    @Qualifier("piano")
    private Instrument instrument;