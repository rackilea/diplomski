// note the type and extra parameter "f"
IntQuadRecursiveFunction exponentiator = (runningResult, binLength, binInt, expBase, f) -> {
   int firstDigit = Integer.parseInt(Integer.toString(binInt).substring(1, 2));
   if (binLength == 0) { // It's "==", not "="
       return runningResult;
   } else if (firstDigit == 0) {
        // note the word "return", which you were missing
        // also the extra argument "f"
       return f.apply((runningResult * runningResult), (binLength - 1), (binInt % (int) Math.pow(10, (int) Math.log10(binInt))), expBase, f);
   } else {
       // should be "expBase", not "base"
       return f.apply((runningResult * runningResult * expBase), (binLength - 1), (binInt % (int) Math.pow(10, (int) Math.log10(binInt))), expBase, f);
   }
};