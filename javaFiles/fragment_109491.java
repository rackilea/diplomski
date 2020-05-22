outerloop:
do {

  for (int i = 0; i < 4; i++) {
    if ((myline = readFile.readLine()) == null) break outerloop;
    // ..
  }

  for (int i = 0; i < 2; i++) {
    if ((myline = readFile.readLine()) == null) break outerloop;
    // ..
  }

  // ..
} while (myline != null);