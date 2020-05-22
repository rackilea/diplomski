boolean ok = false;
for (int k = 0; k < array.length ; k++) {
    if (array[k] >= 50) {
        ok = true;     
    } else {
        ok = false;
        break; //Break the loop, because we have at least one, which is < 50
    }
}