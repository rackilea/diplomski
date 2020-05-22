public class SpecificGeneric {

    public static void main(String[] args) {
        GenericType basicType = new GenericType();

        basicType.display(new String());
        basicType.display(new Integer(1));
        basicType.display(new Double(0.1));
    }
}