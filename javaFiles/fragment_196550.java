if (!paymentFound) {
       System.out.println("Invalid coin or note. Try again. \n");

    }

    if (sum > 0) {
        System.out.format("$%.2f remains to be paid. Enter coin or note: ", sum);
        payment = keyboard.next();
    }