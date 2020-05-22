try {
            System.out.println("Please select a 5 digit card number");
            cardNum.add(input.nextInt());
            checkNumber();
        } catch (invalidNumber err) {
            System.out.println("Caught Error: " + err.getError());
        }