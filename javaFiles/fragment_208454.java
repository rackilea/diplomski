private Environment env;  // a field does not have to be final

public void init() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
             env.close();
        }
     });
}