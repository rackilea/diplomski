for( int i = 0; i < INVENTORY_SIZE; i++ )
{
    System.out.println ("Stock's name:");
    String stockName = console.next();

    System.out.println ("Stock's rating");
    String stockRating= console.next();

    System.out.println ("Stock's price:");
    int stockPrice = console.nextInt();

    System.out.println ("Numbers of shares: ");
    int numberShares= console.nextInt();

    stocks[i] = new Stock( stockName, stockRating, stockPrice, numberShares);
}