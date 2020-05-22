if (test[i] < 0 || test[i] > 100) {
    System.err.println("Test scores must have a value less than 100 and greater than 0.");
    throw new IllegalArgumentException("Test scores must have a value less than 100 and greater than 0.");
} else { 
    scoreArray[i] = test[i];
}