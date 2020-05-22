int evenIdx = 0; 
int oddIdx = 0;

for (i = 0; i < numbers.length; ++i) {
  if (numbers[i] % 2 == 0) {
    evenNumbers[evenIdx++] = numbers[i];
  }
  else {
    oddNumbers[oddIdx++] = numbers[i];
  }
}