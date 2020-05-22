public static void main(String[] args) 
{
    final int SALES_INCREASE = 5000;
    int assignId = 111;
    double assignSales = 25000;
    Salesperson[] salespeople = new Salesperson[10];

    for(int i = 0; i < salespeople.length; i++)
    {
        salespeople[i] = new Salesperson(assignId, assignSales);
        assignId += 1;
        assignSales += SALES_INCREASE;
        System.out.println("Salesperson " + i + " has ID #" + salespeople[i].getId() + 
                " and annual sales of $" + salespeople[i].getSales());
    }
}