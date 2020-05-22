Scanner input = new Scanner//System.in.Scanner;

Account[] atm = new Account[10];

for (int i = 0; i < 10; i++){
    **atm[i] = new Account();**
    atm[i].setId(i);
    atm[i].setBalance(100.00);
}