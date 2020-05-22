public static int encrypt(int number){
    int temp = number;
    int digit4 = (temp + 7) % 10;
    temp = temp / 10;
    int digit3 = (temp + 7) % 10;
    temp = temp / 10;
    int digit2 = (temp + 7) % 10;
    temp = temp / 10;
    int digit1 = (temp + 7) % 10;
    return (digit3 * 1000 + digit4 * 100 + digit1 * 10 + digit2);