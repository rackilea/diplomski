if (myCollection instanceof Queue) {
    ((Queue)myCollection).remove();
} else if (myCollection instanceof Stack) {
    ((Stack)myCollection).remove(thingy);
} else {
    // Oops! Now what?
}