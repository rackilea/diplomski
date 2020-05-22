public static void main(String[] args) {
    int[]bills = {500,200,100,50,20,10,5,2,1};
    int amount=250;
    int sum=0;
    System.out.print("We will need bills for: ");
    while(sum<amount)
    {
        for(int i=0; i < bills.length; i++)
        {
            if(sum+bills[i] <= amount)
            {
                sum+=bills[i];

                System.out.print(bills[i]+", ");

                break;
            }
        }
    }}