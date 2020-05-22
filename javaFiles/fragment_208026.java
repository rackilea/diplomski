// Preparation stuff
private void myNoop() {}
public void publicNoop() {}
public final void finalNoop() {}

// hypothetically illegal (same as your first example)
try {
    // do nothing
} catch (ArrayIndexOutOfBoundsException e) {}

// hypothetically illegal (myNoop() can't be overridden)
try {
    myNoop();
} catch (ArrayIndexOutOfBoundsException e) {}

// hypothetically illegal (finalNoop() can't be overridden)
try {
    finalNoop();
} catch (ArrayIndexOutOfBoundsException e) {}

// legal (publicNoop() could do anything at runtime)
try {
    publicNoop();
} catch (ArrayIndexOutOfBoundsException e) {}