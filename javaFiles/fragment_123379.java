else if (iSBN.compareTo(transISBN)==0)
{
    int change = trans.nextInt();
    amount += change;
    transISBN = trans.next();
}