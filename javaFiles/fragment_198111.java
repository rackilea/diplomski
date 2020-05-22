@Component
public class Main implements RPCInterface {

  @Autowired
  private ServiceA serviceA;

  @Override
  public void outerMethod() throws ExceptionO {

    try {
      serviceA.methodA();

    } catch (ExceptionOne e) {
      throw new ExceptionO(e.getMessage, e);
    } catch (ExceptionTwo e) {
      throw new ExceptionO(e.getMessage, e);
    } catch (ExceptionThree e) {
      throw new ExceptionO(e.getMessage, e);
    }
  }
}

@Service
public class ServiceA implements SA {

  @Autowired
  private ServiceA1 serviceA1;

  @Autowired
  private ServiceB serviceB;

  @Autowired
  private ServiceC serviceC;

  @Override
  @Transactional (value="txManager", propagation=Propagation.REQUIRED, rollbackFor={ExceptionOne.class, ExceptionTwo.class, ExceptionThree.class})
  public void methodA() throw ExceptionOne, ExceptionTwo, ExceptionThree {
    serviceA1.methodA1();
    serviceB.methodB();
    serviceC.methodC();
  }
}

@Service
public class ServiceA1 implements SA1 {
  @Autowired
  private ServiceDBTable1 serviceDBTable1;

  @Autowired
  private ServiceA1A serviceA1A;

  @Transactional
  @Override
  public void methodA1() {
    serviceDBTable4.callToMapper4();
    serviceA1A.methodA1A();
  }
}

@Service
@Transactional (value="txManager", propagation=Propagation.REQUIRED)
public class ServiceA1A implements SA1A {

  @Autowired
  private ServiceDBTable2 serviceDBTable2;

  @Override
  public void methodA1A() {
    serviceDBTable1.callToMapper1();
  }
}

@Service
public class ServiceB implements SB {

  @Autowired
  private ServiceDBTable3 serviceDBTable3;

  @Override
  @Transactional (value="txManager", propagation=Propagation.REQUIRED)
  public void methodB() {
    serviceDBTable3.callToMapper3();
  }
}

@Service
public class ServiceC implements SC {

  @Override
  public void methodC() throws ExceptionThree {
    // code that throws ExceptionThree
  }
}