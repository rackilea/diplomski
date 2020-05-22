@Component
@Profile("test")
public class Toyota implements Car

@Component
@Profile("dev")
public class Bmw implements Car

@Autowired
private Car car;