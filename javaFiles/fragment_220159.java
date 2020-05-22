Scanner s=new Scanner(System.in);
    System.out.println("enter the number to reverse it:\n");
    int num=s.nextInt();
    int original = num;
    int revNum=0;

    while(num!=0)
    {
        revNum=revNum *10;
        revNum= revNum+ num%10;
        num=num/10;
    }
    System.out.println("the reverse of the number is: " +revNum);

        if(revNum==original)
        {
            System.out.println("the number is a palindrome" );

        }
        else
        {
            System.out.println("the number entered is not a palindrome");

        }

    }