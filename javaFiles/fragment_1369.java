public class InstanceofExtension implements Extension {

    @Override
    public List<BinaryOperator> getBinaryOperators() {
        return Arrays.asList(new InstanceofOperator());
    }

    // ...
    // Other methods required by implementing Extension, these other methods can just return null.
    // ...
    // ...

}