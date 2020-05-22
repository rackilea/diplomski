int num = input.nextInt();
        int rev=0;
        int i = 0;
        int originalNum = num;

        while(num!=0){
            rev = num % 10;
            i = i*10 + rev;
            num = num / 10;
        }

            if(originalNum == i)
                System.out.println("The number you input is a palindrome.");
            else
                System.out.println("The number you input is not a palindrome.");