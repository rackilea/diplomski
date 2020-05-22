while(tempPosition < Challenges.chalarray.length) {
    if (Challenges.chalarray[tempPosition][1].contains(value)) {
        String s = Challenges.chalarray[tempPosition][0];
        intvalue = Integer.parseInt(s);
        break;
    }
    tempPosition = tempPosition + 1;
}