public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public Properties getAllProperties() throws IOException {
        return super.mergeProperties();
    }
}