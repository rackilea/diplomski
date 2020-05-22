for(int i = 0; i < businesses.members.size(); i++) {
    if (depositRef == businesses.getReferenceNo(i)) {
        System.out.println("Enter the amount you wish to deposit into " + businesses.getCurrent(i).getName() + "'s account: ");
        balance = input.nextDouble();
        businesses.getCurrent(i).deposit(balance);
        return;
    }
}
System.out.print("Sorry Account doesnt exist. Try again!");