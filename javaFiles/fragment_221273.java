@Component
public class MePage {}

@Profile("android")
@Component
public class AndroidMePage extends MePage {}

@Profile("ios")
@Component
public class IOSMePage extends MePage {}

@Autowired
private List<MePage> pages; // MePage and one of AndroidMePage or IOSMePage , based on active profile