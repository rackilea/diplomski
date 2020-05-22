if (! isAllTheSame(relevantList)) {
    // we have to go deeper!
    count1 = operationsNeeded(updatedList, count1 + 1);
} else {
    // phew, finally done
    System.out.println("check: " + count1);
}