while (intInput != 0)
    {
        intInput = input.nextInt();

        if(intInput<currentMin) currentMin = intInput;
        if(intInput>currentMax) currentMax = intInput;
        System.out.println("currentminis" + currentMin);
        System.out.println("currentmaxis" + currentMax);

        sum += intInput;
        numOfInputs++;
    }