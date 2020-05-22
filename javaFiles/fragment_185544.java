StringBuilder partialName = new StringBuilder();

for(int g = 0; g < NAME_LENGTH_FIRST; g++) {
    char randomChar = pool[random.nextInt((pool.length) - 1) + 1];
    partialName.append(randomChar);
}

PERSON_NAME_FIRST = partialName.toString();