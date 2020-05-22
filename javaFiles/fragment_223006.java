public class P3a {
    private static final double BITCOIN_VALUE = 4000;

    ...
    // your other code
    ...

    buy = myscanner.nextDouble();
    mywallet.add(buy);
    bitcoin = BITCOIN_VALUE * buy;
    USD = USD - bitcoin;
    System.out.println("you have bought:" + mywallet.numcoins);

    ...