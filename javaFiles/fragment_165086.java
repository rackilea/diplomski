try {

        // pass object to printwriter and pw to write to the file
        pw = new PrintWriter(fw);

        // pass user input to object
        AccountWithException acctException = new AccountWithException(fullName, balance, id, RATE);

        System.out.println(acctException.toString());

        // copy object to created file
        pw.println(acctException.toString());
throw new InvalidBalanceException ();

        // custom exception if balance < 0
    } catch (InvalidBalanceException e) {
        System.out.println(e.getMessage());
        System.out.println("Re-enter balance: ");
        balance = input.nextDouble();
    } catch(FileNotFoundException e) {
        System.out.println(e.getMessage());
    } finally {
        System.out.println("Text file closed, program complete...");
        pw.close();
    }