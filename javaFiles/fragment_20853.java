for (int i = 0; i < password.length(); i++) {

    Character c = Character.valueOf(password.charAt(i));
    if (c.isDigit()) {
        totalnumbers++;
    }

    if (c.isLowerCase()) {
        lower++;
    }

    if (c.isUpperCase()) {
        upper++;
    }
}