// Copy splitLeft, allocating extra space.
String[] inWords = Arrays.copyOf(splitLeft, splitLeft.length + 1 + splitRight.length);

// Add the "with" variable, no need to put it in an array first.
inWords[splitLeft.length] = with;

// Copy splitRight into the existing inWords array.
System.arraycopy(splitRight, 0, inWords, splitLength.length + 1, splitRight.length);