String output = "";
while (num > 0) {
  remainder = num % 16;
  if (remainder == 10) {
    output = "a" + output;
  } else if (remainder == 11) {
    output = "b" + output;
  } else if (remainder == 12) {
    output = "c" + output;
  } else if (remainder == 13) {
    output = "d" + output;
  } else if (remainder == 14) {
    output = "e" + output;
  } else if (remainder == 15) {
    output = "f" + output;
  } else {
    output = remainder + output;
  }
  num = num / 16;
}
System.out.println(output);