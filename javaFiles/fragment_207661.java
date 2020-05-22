Member(String giveName, String giveID, String givePinNumber, int giveMoney) {
    Scanner sc = new Scanner(System.in);

    id = giveID;
    while (id.length() != 10) {
        System.out.println("Enter id with length of 10: ");
        id = sc.nextLine();
    }

    pinNumber = givePinNumber;
    while (pinNumber.length() != 4) {
        System.out.println("Enter pin-number with length of 4: ");
        pinNumber = sc.nextLine();
    }

    store = null;
    item = null;
    money = giveMoney;

    sc.close();
}