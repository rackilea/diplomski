int six = 6;
int values[] = new int[six+1]; // waste a byte so it indexes right
for(int i = 0; i < dice.length; i++) {
    values[dice[i]]++;  // keep counts
}

// now do...
boolean hasAThree = false;
boolean hasATwo = false;

for(int i = 1; i <= six; i++) {
    if(values[i] == 3) {
        hasAThree = true;
    }
    if(values[i] == 2) {
        hasATwo = true;
    }
}

if(hasAThree && hasATwo) {
    // full house
}