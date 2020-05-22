@Component
    public class Parent {

        @Autowired
        private InnerChild innerChild;

        @Component
        private static class InnerChild {

        }

    }