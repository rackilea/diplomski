int numberOfCharacters = 8;
char[] letters = new char[numberOfCharacters];
Random random = new Random();
for(int i = 0; i < numberOfCharacters; i++) {
    letters[i] = (char) (random.nextInt(26) + 'a');
}