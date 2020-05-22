if (myValues.length == 0) {
        throw new IllegalStateException();
    }
    else if (myValues.length == 1) {
        return myValues[0];
    }
    else {
        int halfRoundedUp = myValues.length / 2;
        if (myValues.length % 2 == 0) { // even count, average the middle values
            return (myValues[halfRoundedUp - 1] + myValues[halfRoundedUp]) / 2;
        }
        else { // odd, take the middle value
            return myValues[halfRoundedUp];
        }
    }