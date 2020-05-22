while (usrInput != 0) {
    if (usrInput > 0)
        pos++;
    else
        neg++;

    total += usrInput;
    count++;
    System.out.println("Enter an integer, the input ends if it is 0: ");
    usrInput = input.nextInt();
}