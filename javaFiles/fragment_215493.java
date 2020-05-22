public static String masked(String card_number) {
    if(card_number.length() < 9){
        return maskedAll(card_number);
    }

    return new StringBuilder().append(card_number.substring(0, 4)).append("....")
            .append(card_number.substring(card_number.length() - 3, card_number.length())).toString();
}

public static String maskedBin(String card_number) {
    if(card_number.length() < 5){
        return maskedAll(card_number);
    }

    return new StringBuilder().append(card_number.substring(0, 4)).toString();
}

public static String maskedTail(String card_number) {
    if(card_number.length() < 5){
        return maskedAll(card_number);
    }

    return new StringBuilder().append(card_number.substring(card_number.length() - 3, card_number.length())).toString();
}

public static String maskedAll(String card_number) {
    return String.join("", Collections.nCopies(card_number.length(), "X"));
}