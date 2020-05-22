@Service
public class TicketService {

  @Autowired
  private TicketRepository repo;

  public List<?> getTicketEventCount() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.MONTH, -1);
    Date date = cal.getTime();

    List<?> results = repo.getEventCount(true, date);
    return results;
  }
}