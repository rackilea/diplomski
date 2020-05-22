1054    public BigInteger add(BigInteger val) {
 1055         int[] resultMag;
 1056         if (val.signum == 0)
 1057             return this;
 1058         if (signum == 0)
 1059             return val;
 1060         if (val.signum == signum)
 1061             return new BigInteger(add(mag, val.mag), signum);
 1062 
 1063         int cmp = intArrayCmp(mag, val.mag);
 1064         if (cmp==0)
 1065             return ZERO;
 1066         resultMag = (cmp>0 ? subtract(mag, val.mag)
 1067                            : subtract(val.mag, mag));
 1068         resultMag = trustedStripLeadingZeroInts(resultMag);
 1069 
 1070         return new BigInteger(resultMag, cmp*signum);
 1071     }