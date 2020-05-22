@Component
@Qualifier("toyota")
public class Toyota implements Car

@Component
@Qualifier("bmw")
public class Bmw implements Car

@Autowired
@Qualifier("toyota")
private Car car;