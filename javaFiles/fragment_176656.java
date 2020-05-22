int persons[] = new int[NUM_OF_PERSONS];

int basicRation = NUM_TO_DISTRIBUTE / NUM_OF_PERSONS;
int peopleGettingExtra = NUM_TO_DISTRIBUTE % NUM_OF_PERSONS;

for ( int i = 0; i < NUM_OF_PERSONS; i ++ ) {
    persons[i] = basicRation + ( i < peopleGettingExtra ? 1 : 0 );
}