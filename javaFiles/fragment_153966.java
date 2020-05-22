class MyEnvironmentAware implements EnvironmentAware{
    private static Environment env = null;

    @Override
    public void setEnvironment(Environment environment) {
            env = environment;
            //log the stuff you want here
     }
}