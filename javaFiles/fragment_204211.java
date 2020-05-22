public String generateCardNo(int expiryDay, int expiryMonth, char firstNameInitial, char   surnameInitial)
{ 
    int firstNameInitialNumber = formatInitial(firstNameInitial);
    int surnameInitialNumber = formatInitial(surnameInitial);

    Random rand = new Random();

    int num1 = 4 + rand.nextInt(5);
    int num2 = (expiryDay + expiryMonth) % 10;
    int num3to4 = rand.nextInt(100);
//  int num4 = rand.nextInt(10);
    int num5 = rand.nextInt(10);
    int num6to10 = rand.nextInt(100000);
//  int num7 = rand.nextInt(10);
//  int num8 = rand.nextInt(10);
//  int num9 = rand.nextInt(10);
//  int num10 = rand.nextInt(10);
    int num11 = rand.nextInt(10);
    int num12to14 = rand.nextInt(1000); 
//  int num13 = rand.nextInt(10);
//  int num14 = rand.nextInt(10);
    int num15 = (firstNameInitialNumber + surnameInitialNumber) % 10;
    int num16 = (num1 + num5 + num11) % 10;

   String cardNumStr = "" + num1 
                          + num2 
                          + String.format("%02d", num3to4) 
                          + num5 
                          + String.format("%05d", num6to10 
                          + num11 
                          + String.format("%03d", num12to14) 
                          + num15 
                          + num16;

    return cardNumStr;
}