class Change {
int index;
char values[];
int cur;

void reset() {cur=0;}
boolen isMax(){return cur==values.length-1;}
void next(){cur++;}
char getValue(){ return values[cur]; }
}