if ((temp - lowerPrime) == (greaterPrime - temp)) {
    b[k] = lowerPrime;
} else if ((temp - lowerPrime) < (greaterPrime - temp)) {
    b[k] = lowerPrime;
} else if ((temp - lowerPrime) > (greaterPrime - temp)) {
    b[k] = greaterPrime;
}