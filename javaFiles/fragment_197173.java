Rectangle r1 = new Rectangle();
// r1 is pointing to that address
Rectangle r2 = r1;
// now r2 is pointing to the same address (same object) with r1
r2 = null;
// now r2 is null, but the object is still in the heap.
// r2 doesn't point to that object anymore.