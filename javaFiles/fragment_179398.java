int count = 0;
    for(int i = 1; i<=11; i++)
    {
        String number = String.valueOf(i);
        while(number.contains("1"))
        {
            number= number.substring(number.indexOf("1")+1);
            count ++;
        }
    }
    System.out.println(count);