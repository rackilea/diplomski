int len = 0;
if (smallOption) {
    for (char c : leterSmall) {
        arrayFinal[len++] = c;
    }
}
if (bigOption) {
    for (char c : leterBig) {
        arrayFinal[len++] = c;
    }
}
if (numbersOption) {
    for (char c : numbers) {
        arrayFinal[len++] = c;
    }
}
if (charactersOption) {
    for (char c : charsRandom) {
        arrayFinal[len++] = c;
    }
}

ThreadLocalRandom rnd = ThreadLocalRandom.current();
for (int i = 0; i < 16; i++) {
    System.out.print(arrayFinal[rnd.nextInt(len)]);
}