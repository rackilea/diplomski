while(flag)
    {
        int thisRandNum = randNum.nextInt(45 - nextNum) + 1;
        System.out.println(thisRandNum);
        nums.add(thisRandNum);
        sum+=thisRandNum;
        nextNum = thisRandNum;
        if(sum == 45)
        {
            flag = false;
        }
    }