PVector prev = new PVector();
PVector current = new PVector();

void draw() {
     current = howeverYouAreGettingTheData();

     //this is your direction vector for their swiping
     PVector direction = PVector.sub(current, prev);

     //set the previous one to the current for the next calculation.
     prev.set(current.x, current.y, current.z);
}