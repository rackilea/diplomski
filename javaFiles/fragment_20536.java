// Fill the whole array with zeros using relative set
// First position to the beginning:
arr.pos(0, 0);

// And execute a "set zero" operation
// as many times as many elements the array has:
for ( int i = rows * cols; i > 0; i--)
    arr.set(0);