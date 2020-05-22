try {
            System.out.println("Please select a 5 digit card number");
            int number = input.nextInt();
            cardNum.add(number);
            checkNumber(number);
        } catch (invalidNumber err) {
            System.out.println("Caught Error: " + err.getError());
        }