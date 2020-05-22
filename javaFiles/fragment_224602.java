@Scope("step")
 public class MajorItemReader implements InitializingBean{

        private List<YourItem> yourItems= null;

        @Autowired
        private MyService provider;


        public YourItem read() {
            if ((yourItems!= null) && (yourItems.size() != 0)) {
                return yourItems.remove(0);
            }
            return null;
        }

        //Reading Items from Service
        private void reloadItems() {

        this.yourItems= new ArrayList<YourItem>();
        // use the service to provide your Items
       if (yourItems.isEmpty()) {
                yourItems= null;
            }
        }
        public MyService getProvider() {
            return provider;
        }
        public void setProvider(MyService provider) {
            this.provider = provider;
        }
        @Override
        public void afterPropertiesSet() throws Exception {
            reloadItems();
        }
}