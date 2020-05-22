Map<String, Map<String, int>> dict = ...;
...
int score;
Map<String, int> mcw = dict.get( cw );

for ( mcw.values() : int s) {
    score += s;
}