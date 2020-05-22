public String toString() {
    String result = "";

    for (int scan = 0; scan < numberOfcarsInQueue; scan++)
        result = result + carArray[scan].toString() + "\n";

    return result;
}