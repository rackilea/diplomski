String[] option={"yes", "no", "maybe", "possibly"};

    int count = 1;
    while (randomnumber < 10 && count <= option.length){ //if count is more than array option's size, arrayIndexOutOfBoundException
        count = count + 1;
        System.out.print(option[count-1]);
    }