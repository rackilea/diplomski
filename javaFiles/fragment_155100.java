int index = 0;
    while (index < 10) {
        int i2 = i + 1;
        Log.d("TAG", "i val:" + i);
        index++;
        i = i2;
    }
    System.out.println("i:" + i);