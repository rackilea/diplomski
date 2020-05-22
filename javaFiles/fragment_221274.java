@Component
@Qualifier("default")
public class MePage {}

@Profile("android")
@Component
@Qualifier("android")
public class AndroidMePage extends MePage {}

@Profile("ios")
@Component
@Qualifier("ios")
public class IOSMePage extends MePage {}

@Autowired
@Qualifier("default")
private MePage mePage; // MePage is injected, regardless of active profile

@Autowired
@Qualifier("ios")
private MePage mePage; // IOSMePage if ios profile is active

@Autowired
@Qualifier("android")
private MePage mePage; // AndroidMePage if android profile is active