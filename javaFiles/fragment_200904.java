public String toString() {
        // Maybe you should use java.lang.StringBuilder instead
        String returnValue = "[Set:";

        if (isEmpty())
          returnValue += "---";

        for (int i=0; i<a.length; i++) {
          if (isSet(i))
            returnValue += " " + i;
        }

        returnValue += "]\n";

        return returnValue;
    }