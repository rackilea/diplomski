public void purchase(Item i, double balance) throws InsufficientFunds Exception {
    //more codes here if we have enough money

    if (balance < i.getCost()) {
        throw new InsufficientFundsException(i.getCost() - balance); //throw an exception! we don't have enough money
    }
}