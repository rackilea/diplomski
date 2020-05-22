int[] scores = new int[3];

while (...) {
    ...

    ++scores[ winner ];

    for (int i = 1; i < scores.length; ++i) {
        System.out.printf("Player %d score is %d.\n", i, scores[i]);
    }
}