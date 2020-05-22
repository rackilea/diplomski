String doubleDigit(Integer digit) {

      if (digit == 0) {
        return "";
      } else {
        Integer thisDigit = digit % 10;
        Integer remainingDigits = (digit - thisDigit) / 10;
        return doubleDigit(remainingDigits) + thisDigit.toString() + thisDigit.toString();
      }
    }