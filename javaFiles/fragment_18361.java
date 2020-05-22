final int[] coin_values = new int[]{
     200 , 100 , 50 , 20 , 10 , 5 , 2 , 1};
final String[] coin_names = new String[]{
     "2€" , "1€" , "50ct" , "20ct" , "10ct" , "5ct" , "2ct" , "1ct"};

String input = in.next();
String[] temp = input.split(".");
input = temp[0] + temp[1];
int value = Integer.parseInt(input);

int[] coins = new int[coin_values.length];

for(int i = 0 ; i < coins.length ; i++){
     coins[i] = value / coin_values[i];
     value %= coin_values[i];

     if(coins[i] != 0)
          System.out.print(coins[i] + " " + coin_names[i] + " + ");
}