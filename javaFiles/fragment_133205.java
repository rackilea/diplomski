Double average = 0D;
int counter = 0;
for (Measurement measure : measurements) {
    if (measure.map.get("score") != null) {
        average += measure.map.getOrDefault("score", 0D);
        counter++;
    }
}
average /= counter;