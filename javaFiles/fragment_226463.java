public abstract class PayByQualifier extends AnnotationLiteral<PayBy> implements PayBy {
}

PayBy payByCheque = new PayByQualifier() {
    public PaymentMethod value() {
        return CHEQUE;
    }
};