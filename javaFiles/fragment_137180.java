List<Integer> timestamps;
int target = 59999; // matches are from 58999 to 999 (wrapped around)
for (Integer timestamp : timestamps) {
    if (Math.abs(timestamp + 60000 - target) <= 1000 || Math.abs(timestamp - target) <= 1000) {
        // this timestamp is a match
    }
}