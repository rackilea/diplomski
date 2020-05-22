int life= 0;
int pos;
for (int j = 0; j < 100; j++) {
    char config[] = new char[10]; // <<== Move the declaration here
    for (int i = 0; i < 10; i++) {
        do {
            pos = rand.nextInt(10);
        } while (source[pos] == '?');
        config[i] = source[pos];
        source[pos] = '?';
    }
    life= rand.nextInt((30 + 1) -1);
    population[j] = new Individual(config, 0, life);
}