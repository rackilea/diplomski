public void accept(String s) {
        checkNotNull(s); // that is, s != null is a precondition of the method

        stringsSeen++;
        totalLengthSeen += s.length();
    }