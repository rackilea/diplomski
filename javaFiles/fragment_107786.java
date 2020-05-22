@Component
public class SomeService {

    public void test() {
        Logger logger = LoggerFactory.getLogger(SomeService.class);
        logger.error("hey");
    }
}