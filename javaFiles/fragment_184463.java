for (int i = 0; i < 11; i++) {
    if (number - binaryValues[i] >= 0) {
        result = result + "1";
        number -= binaryValues[i];
    } else {
        result = result + "0";
    }
}