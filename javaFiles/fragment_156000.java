import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private final List<TransactionLine> transactionLines = new ArrayList<>();

    public void add(final String name) {
        final TransactionLine tl = new TransactionLine(transactionLines.size(), name);

        transactionLines.add(tl);
    }

    public boolean containsName(final String name) {
        for (final TransactionLine transactionLine : transactionLines) {
            if (transactionLine.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

}