boolean allMatch = true;
for (String string : strings) {
    if (!string.equals(str)) {
        allMatch = false;
        break;
    }
}