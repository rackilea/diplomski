Clock clock = Clock.systemDefaultZone();

int samples = 1_000;
LocalDateTime[] instants = new LocalDateTime[samples];

int k = 0;

for (int i = 0; i < samples; i++) {
    instants[i] = LocalDateTime.now(clock);
    for (int j = 0; j < 10000; j++) {
        k = j % 2;
    }
}