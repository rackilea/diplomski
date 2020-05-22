int digitNumber = 1;
    int sum = 0;
    String binary = "011110101010";
    for(int i = 0; i < binary.length(); i++){
        if(digitNumber == 1)
            sum+=Integer.parseInt(binary.charAt(i) + "")*8;
        else if(digitNumber == 2)
            sum+=Integer.parseInt(binary.charAt(i) + "")*4;
        else if(digitNumber == 3)
            sum+=Integer.parseInt(binary.charAt(i) + "")*2;
        else if(digitNumber == 4 || i < binary.length()+1){
            sum+=Integer.parseInt(binary.charAt(i) + "")*1;
            digitNumber = 0;
            if(sum < 10)
                System.out.print(sum);
            else if(sum == 10)
                System.out.print("A");
            else if(sum == 11)
                System.out.print("B");
            else if(sum == 12)
                System.out.print("C");
            else if(sum == 13)
                System.out.print("D");
            else if(sum == 14)
                System.out.print("E");
            else if(sum == 15)
                System.out.print("F");
            sum=0;
        }
        digitNumber++;  
    }