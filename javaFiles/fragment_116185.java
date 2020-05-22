public class CompositeABService {
  @Autowired
  private AService aservice;
  @Autowired
  private BService bservice;

  @Transactional
  public void save(Object value1, Object value2) {
    aservice.save( value1 );
    bservice.save( value2 );
  }
}

public class AService {
  @Transactional
  public void save(Object value) {
    // joins an existing transaction if one exists, creates a new one otherwise.
  }
}

public class BService {
  @Transactional
  public void save(Object value) {
    // joins an existing transaction if one exists, creates a new one otherwise.
  }
}