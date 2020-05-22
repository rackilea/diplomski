private static class CustomPropertySource extends PropertySource<String> {

    public CustomPropertySource() {super("custom");}

    @Override
    public String getProperty(String name) {
        if (name.equals("myCalculatedProperty")) {
            return magicFunction();  //you might cache it at will
        }
        return null;
    }
}