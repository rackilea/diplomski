int iterations = stoi(argv[1]);
int load = stoi(argv[2]);

long long x = 0;

for(int i = 0; i < iterations; i++) {

    long start = get_nano_ts(); // START clock

    for(int j = 0; j < load; j++) {
        if (i % 4 == 0) {
            x += (i % 4) * (i % 8);
        } else {
            x -= (i % 16) * (i % 32);
        }
    }

    long end = get_nano_ts(); // STOP clock

    // (omitted for clarity)
}

cout << "My result: " << x << endl;