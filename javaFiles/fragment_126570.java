public String toString() {
    if (imaginaryPart == 0)
        return String.valueOf(realPart);
    if (realPart == 0)
        return String.valueOf(imagPart) + "i";
    return realPart + "+" + imagPart + "i";
}