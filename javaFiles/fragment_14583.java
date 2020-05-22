boolean valid = false;
int input = -1;
Scanner in = new Scanner(System.in);
do{
    System.out.println("Please enter a number bigger than 5: ");
    String val = in.nextLine();
    if(val.matches("\\d+"))
        input = Integer.parseInt(val);

    if(input ==(int)input && input > 5)
        valid = true;
}while(!valid);

System.out.print(input + " is greater than 5.");