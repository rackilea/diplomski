public void enterCustomers() {

        ArrayList CustomerDetails = new ArrayList();

        while (true) {

            System.out.print("Enter Name: ");
            // account.name = scanner.next();
            // don't set input directly to account
            String inputName = scanner.next();
            // check given input
            if (inputName.equals("q")) {

                break;

            } else {
                Input.promptText("Enter balance: ");
                account.name = inputName;
                account.balance = scanner.nextDouble();

                CustomerDetails.add(account.name);
                CustomerDetails.add(account.balance);

                System.out.println("Enter customer names or q to quit entering names");

            }

        }

    }