public class ListStuff {

List<Transaction> transactions = new ArrayList<>();

public ListStuff() {
    //Add some data
    transactions.add(new ATransaction());
    transactions.add(new DTransaction());
    transactions.add(new ATransaction());
    transactions.add(new ATransaction());
    transactions.add(new CTransaction());
    transactions.add(new ATransaction());
    transactions.add(new BTransaction());
    transactions.add(new CTransaction());
    transactions.add(new BTransaction());
    transactions.add(new BTransaction());
    transactions.add(new CTransaction());
    transactions.add(new CTransaction());
    transactions.add(new DTransaction());

    remove(ATransaction.class); //This will remove all ATrasaction from the list
    remove(BTransaction.class); // This will remove all BTransaction from the list
    transactions.stream().forEach(System.out::println);
}


public void remove(Class<? extends Transaction> cls) {
    Iterator itr = transactions.iterator();

    while (itr.hasNext()) {
        if (itr.next().getClass().equals(cls)) {
            System.out.println("removing");
            itr.remove();
        }
    }
}


public abstract class  Transaction {


}


public class ATransaction extends Transaction{

    @Override
    public String toString() {
        return "A";
    }

}

public class BTransaction extends Transaction{
    @Override
    public String toString() {
        return "B";
    }
}

public class CTransaction extends Transaction{
    @Override
    public String toString() {
        return "C";
    }
}

public class DTransaction extends Transaction{
    @Override
    public String toString() {
        return "D";
    }
}
}