Member(String giveName, String giveID, String givePinNumber, int giveMoney) {
    if (giveID.length() != 10)
        throw new IndexOutOfBoundsException("ID-length must be 10!");
    if (givePinNumber.length() != 4)
        throw new IndexOutOfBoundsException("PIN-length must be 4!");

    id = giveID;
    pinNumber = givePinNumber;
    store = null;
    item = null;
    money = giveMoney;

}