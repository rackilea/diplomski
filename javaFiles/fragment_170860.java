int firstNum;
    int secondNum = 1;
    int num;
    int count = 0;

    System.out.println("Sample run: \n\nPrime numbers");
    do {
        num = 0;
        firstNum = 2;
        while (firstNum <= secondNum / 2) {
            if (secondNum % firstNum == 0) {
                num++;
                // count++; // <--- Remove this.
                break;
            }
            firstNum++;
        }
        if (num == 0 && secondNum != 1) {
            count++;
            System.out.println(secondNum); // Use println() for new line.
        }
        secondNum++;
    } while(count < 25);
}