int compare = msgPushedTimestamp.compareTo(logFileTimestamp);
if (compare < 0) {
    // msgPushedTimestamp is earlier
} else if (compare > 0) {
    // logFileTimestamp is earlier
} else {
    // they are equal
}