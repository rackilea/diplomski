@Component
public class MePage {}

@Profile("android")
@Component
@Primary
public class AndroidMePage extends MePage {}

@Profile("ios")
@Component
@Primary
public class IOSMePage extends MePage {}

@Autowired
private MePage mePage; // AndroidMePage if android profile is active

@Autowired
private MePage mePage; // IOSMePage if ios profile is active