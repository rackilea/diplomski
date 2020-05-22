while (checkUserInput != 0) {
    System.out.println("Please enter the customer name");
    customerName.add(userInput.nextLine());
    System.out.println("Please enter the customer amount");
    customerSpend.add(Double.parseDouble(userInput.nextLine()));

    if (customerSpend.get(customerSpend.size()-1) == 0){
        checkUserInput = 0;
    }
}