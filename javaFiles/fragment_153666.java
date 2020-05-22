StringBuilder msg = new StringBuilder("You have:");
if (dollars > 0) {
    msg.append(" ").append(dollars).append(" dollar").append(dollars > 1 ? "s" : "");
}
if (quaters > 0) {
    msg.append(" ").append(quaters).append(" quarter").append(quaters > 1 ? "s" : "");
}
if (dimes > 0) {
    msg.append(" ").append(dimes).append(" dime").append(dimes > 1 ? "s" : "");
}
if (nickels > 0) {
    msg.append(" ").append(nickels).append(" nickel").append(nickels > 1 ? "s" : "");
}
if (pennies > 0) {
    msg.append(" ").append(pennies).append(" pennie").append(pennies > 1 ? "s" : "");
}

System.out.println(msg);