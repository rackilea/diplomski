int counter = 0;
for (String item : array) { // Or whatever the type should be
    if (item != null) {
        counter++;
    } else {
        break;
    }
}