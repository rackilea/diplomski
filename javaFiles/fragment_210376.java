System.out.print("Enter number of times: ");
    int times = number.nextInt();

    int i = 1;
    int temp=0;
    int inputArray[] = new int[times];

    while ( i <= times){
        System.out.print("Enter a number : ");
        int input = number.nextInt();
        i++;
            if( input == temp){
                System.out.println("It is already taken");
                i--;
            }else {
                        inputArray[i-2]=input;
                    }
        temp=input;
    }
}