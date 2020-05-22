let rowTotal1 = 0;
let hasSpecialNames = false;

for(int i=0; i<5; i++) {
  rowTotal1 += square[0][i].value;

  if (square[0][i].name == "AA" ||
                       square[0][i].name == "AB" ||
                       square[0][i].name == "AC" ||
                       square[0][i].name == "AD") {
    hasSpecialNames = true;
  }
}

if(rowTotal1 > 21 || hasSpecialNames) {
  rowTotal1 = rowTotal1 - 10;
}