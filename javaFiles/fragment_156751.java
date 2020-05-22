int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        int index = 0;
        Random rnd = new Random();

        for (int i = 0; i < 3; i ++)
        {
            index = index + rnd.nextInt(numbers.length);
        }
        index=index/3;

        System.out.println(numbers[index]);