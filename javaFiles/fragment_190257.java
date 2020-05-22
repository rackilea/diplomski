for (String ord : ordinals) {
    if (dateint.contains(ord)) {
        dateint = dateint.substring(0, dateint.length() - 2);
        break;
    }
}