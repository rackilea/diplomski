public static void readLoans(){
    // Reads the bookList and userList.
    readBooks();
    readUsers();
    // Creates a new BufferedReader and tries to read "loans.txt"
    BufferedReader reader = null;
    try {
        reader=new BufferedReader(new FileReader("loans.txt"));
    }
    // Catches exception if "books.txt" does not exist.
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    String line = null;
    // tries to read the first line and interpret it as a String.
    try {
        line = reader.readLine();
    } 
    // Catches IOexception if any is thrown when trying to read line.
    catch (IOException e) {
        e.printStackTrace();
    }
    // Loop as long as "line" is not empty, i.e. as long as a Loan is read.
    while (line!=null) {
        // split the String "line" at every RegEx "-"
        String[] splitOut=line.split("-");
        // Create a String from the first index of the first split.
        String user = splitOut[0];
        /* Split the second and third index of the first split and create
         * new Stringarrays from them.*/
        String[] loans = splitOut[1].split(",");
        String[] returns = splitOut[2].split(",");
        User aUser = new User();
        /* Find the user in the userList whose personal ID matches the 
         * String "user" that we created. This is the user that we want to
         * create (a) loan/s and/or (a) returned loan/s for.*/
        for (int i = 1; i < userList.size()+1; i++) {
            if (userList.get(i).getPersonalID().equals(user)) {
                /*Set the variables for the User.*/
                aUser.setFirstname(userList.get(i).getFirstname());
                aUser.setSurname(userList.get(i).getSurname());
                aUser.setPersonalID(userList.get(i).getPersonalID());
                aUser.setTelephone(userList.get(i).getTelephone());
                aUser.setLoans(userList.get(i).getLoans());
                aUser.setReturns(userList.get(i).getReturns());
                // Create an ArrayList for Loans and Returns for every user
                ArrayList<Loan> listOfloans = new ArrayList<Loan>();
                ArrayList<Loan> listOfreturns = new ArrayList<Loan>();
                // if the new user has any loans...
                for (int j = 0; j < aUser.getLoans(); j++) {
                    for (int k = 1; k < bookList.size()+1; k++) {
                        /* ... find the "Book" object with the
                         * corresponding ISBN...*/
                        if (bookList.get(k).getIsbn().equals(loans[j*3])) {
                            // ...then create a new loan object for each...
                            Loan loan = new Loan();
                            // ...and set the variables of each loan...
                            loan.setTitle(bookList.get(k).getTitle());
                            loan.setAuthor_firstname(bookList.get(k).
                                    getAuthor_firstname());
                            loan.setAuthor_surname(bookList.get(k).
                                    getAuthor_surname());
                            try {
                                loan.setIsbn(bookList.get(k).getIsbn());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            loan.setMaxLoan(bookList.get(k).getMaxLoan());
                            loan.setOnLoan(bookList.get(k).getOnLoan());
                            loan.setAvailable(bookList.get(k).
                                    getAvailable());
                            loan.setSignature(loans[j*3+1]);
                            loan.setTimestamp(loans[j*3+2]);
                            /* ...then add each one to the "listOfloans"
                             * ArrayList.*/
                            listOfloans.add(loan);
                        }
                    }
                }
                /* if the "listOfloans" ArrayList is not empty, 
                 * add the loan to loanList with User as Key.*/
                if (!listOfloans.isEmpty()) {
                    loanList.put(aUser, listOfloans);
                }
                // if the new user has any returned loans...
                for (int j = 0; j < aUser.getReturns(); j++) {
                    for (int k = 1; k < bookList.size()+1; k++) {
                        /* ... find the "Book" object with the
                         * corresponding ISBN...*/
                        if(bookList.get(k).getIsbn().equals(returns[j*4])){
                            // ...then create a new loan object for each...
                            Loan loan = new Loan();
                            // ...and set the variables of each loan...
                            loan.setTitle(bookList.get(k).getTitle());
                            loan.setAuthor_firstname(bookList.get(k).
                                    getAuthor_firstname());
                            loan.setAuthor_surname(bookList.get(k).
                                    getAuthor_surname());
                            try {
                                loan.setIsbn(bookList.get(k).getIsbn());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            loan.setMaxLoan(bookList.get(k).getMaxLoan());
                            loan.setOnLoan(bookList.get(k).getOnLoan());
                            loan.setAvailable(bookList.get(k)
                                    .getAvailable());
                            loan.setSignature(returns[j*4+1]);
                            loan.setTimestamp(returns[j*4+2]);
                            loan.setReturndate(returns[j*4+3]);
                            /* ...then add each one to the "listOfreturns"
                             * ArrayList.*/
                            listOfreturns.add(loan);
                        }
                    }
                }
                /* if the "listOfreturns" ArrayList is not empty, 
                 * add the returned loan to returnList with User as Key.*/
                if (!listOfreturns.isEmpty()) {
                    returnList.put(aUser, listOfreturns);   
                }
            }
        }
        // tries to read the next line and interpret it as a String.
        try {
            line=reader.readLine();
        }
        // Catches IOexception if any is thrown when trying to read line.
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // try to close the BufferedReader.
    try {
        reader.close();
    }
    // Catches IOexception if any is thrown when trying to close.
    catch (IOException e) {
        e.printStackTrace();
    }
}