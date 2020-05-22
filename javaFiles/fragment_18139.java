import javax.enterprise.util.AnnotationLiteral;

public class MyQualifierLiteral extends AnnotationLiteral<MyQualifier> implements MyQualifier {

    private final String value;

    public MyQualifierLiteral(final String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }

}