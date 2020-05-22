double underPay = feeSum - transaction;
            while (underPay != 0) {
                System.out.println("The transaction did not meet the fee by $" + underPay);
                System.out.println("Please enter another payment to complete the balance.");
                int paymentSizeNext = keyboard.nextInt();
                underPay -= paymentSizeNext;


            }
            System.out.println("There is now no outstanding balance.");