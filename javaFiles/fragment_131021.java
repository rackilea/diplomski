boolean found = false;
for (String element : array) {
    if (str.equals(element)) {
        found = true;
        break;
    }
}
if (!found) {
    // add str to array, but where? Use a Set instead.
}