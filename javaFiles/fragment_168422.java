public abstract class ChequePrinter<T> implements Printer<T, PrintLayout> {
    public abstract print(T cheque);
}

public VoidChequePrinter extends ChequePrinter<VoidCheque> {
    public print (VoidCheque cheque);
}