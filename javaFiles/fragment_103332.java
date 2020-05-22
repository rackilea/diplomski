import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Auditorium {
    private static final Logger log = LoggerFactory.getLogger(Auditorium.class);
    private Integer id;

    @Value("${auditorium1.name}")
    private String name;

    @Value("${auditorium1.number-of-seats}")
    private Integer numberOfSeats;

    @Value("${auditorium1.vip-seats}")
    private List<String> vipSeats;

    @PostConstruct
    private void doAfterConstruction() {
        log.debug(this.toString());
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + vipSeats +
                '}';
    }
}