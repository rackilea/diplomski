public class MyStrategy extends DefaultGeneratorStrategy {
    @Override
    public List<String> getJavaClassImplements(Definition definition, Mode mode) {
        if (mode == Mode.RECORD && definition.getQualifiedName().matches("some regex")) {
            return Arrays.asList(MyCustomInterface.class.getName());
        }
    }
}