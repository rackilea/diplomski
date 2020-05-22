double score = 0;
double alpha = 1.0 / 28;
boolean contacted = true;
for (int i = 0; i < 200; i++) {
    score = (contacted ? 1 : 0) * alpha + score * (1 - alpha);
    System.out.printf("%.3f%n", score);
}