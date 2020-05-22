public static void main(String[] args) {
    int a[] = {0, 1};

    int number;
    int remainder;
    String binary = "";

    Scanner in = new Scanner(System.in);

    System.out.print("Enter Decimal Number: ");
    number = Integer.parseInt( in.next());

    System.out.print("Binary Number in Reverse: ");
    do {
        remainder=number%2;
        if(remainder > 0){
            binary += a[1];
            //System.out.print(a[1]);
        }
        else{
            binary += a[0];
            //System.out.print(a[0]);
        }
        number=number / 2;
    } while(number>0);

    System.out.print(binary);

    System.out.print(" \nDecimal number: ");
    //String s = Integer.toString(number);
    double result = 0;
    for (int i = 0; i < binary.length(); i++)
       result = result + Double.parseDouble(binary.substring(i, i + 1)) * Math.pow(2, i);
    System.out.print(result);
}