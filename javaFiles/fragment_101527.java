for (index = 0; index < count; index++) {
  int value = Integer.parseInt(numbers[index]);
  if (value < lowest) {
       lowest = value;
  } else if (value > highest) {
       highest = value;
  }

  total = total + value;
}