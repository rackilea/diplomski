@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Config.class)
public class AspectTesting {

    @Autowired
    ServiceWithAspect service;

    @Autowired
    Verifier verifyingAspect;

    @Test
    public void test() {
        // given
        boolean condition = false;

        // when
        try {
            service.doit();
        } catch (Exception swallow) {}

        // then
        try {
            condition = ((VerifyingAspect) ((Advised) verifyingAspect).getTargetSource().getTarget()).wasExecuted();
        } catch (Exception swallow) {}

        // then
        Assert.assertTrue(condition);
    }
}

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aspects")
class Config {
}

@Component
class VerifyingAspect implements Verifier {

    private boolean executed = false;

    public boolean wasExecuted() {
        return executed;
    }

    @Override
    public void invoked() {
        executed = true;
    }
}

@Service
class ServiceWithAspect {
    public void doit() {
        throw new RuntimeException();
    }
}

@Component
@Aspect
class TestedAspect {

    @Autowired
    Verifier verifier;

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        // your aspect logic here
        verifier.invoked();
    }
}

interface Verifier {
    void invoked();
}