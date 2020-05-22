SecureRandom secureRandom = new SecureRandom();
int rand = 0;
for (int i = 0; i < 8; i++) {
    rand = (int) (secureRandom.nextDouble() * 3);
    switch (rand) {
        case 0:
            c = '0' + (int) (secureRandom.nextDouble() * 10);
            break;
        case 1:
            c = 'a' + (int) (secureRandom.nextDouble() * 26);
            break;
        case 2:
            c = 'A' + (int) (secureRandom.nextDouble() * 26);
            break;
    }
}