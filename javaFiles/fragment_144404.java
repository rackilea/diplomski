ArrayList<Account> tempList = new ArrayList<Account>();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                templist.add(account.name);
            }
        }
        System.out.println(tempList);
        return tempList; //Returning an empty list is better than returning null