//calculating the reverse order of the entered integer
loopNumber = number;
while(loopNumber != 0) {
    reverse *= 10;
    reverse = reverse + (number%10);
}