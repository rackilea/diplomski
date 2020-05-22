Random r = new SecureRandom();
while (System.currentTimeMillis() <= endTime) {
    int randomID;
    if ( r.nextFloat() < percentageValidId/100 )
        randomID = r.nextInt(endValidRange - startValidRange + 1) + startValidRange;
    else
        randomID = r.nextInt(endNonValidRange - startNonValidRange + 1) + startNonValidRange;
    // Print it
}