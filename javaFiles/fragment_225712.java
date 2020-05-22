private static long setMaskedValue (long maskedValue, long mask, long valueToAdd) {
            int nbZero=0;
            int nbLeastSignificantBit=0;
            long tmpMask=mask;
            maskedValue = maskedValue & ~mask;

            while (tmpMask != 0){
                while ((tmpMask & 1) == 0){
                    tmpMask = tmpMask >>> 1;
                    nbLeastSignificantBit++;
                    nbZero ++;
                }

                while ((tmpMask & 1) == 1){
                    tmpMask = tmpMask >>> 1;

                    BigInteger bigValueToAdd = BigInteger.valueOf(valueToAdd).shiftLeft(nbZero);
                    long tmpValueToAdd = bigValueToAdd.longValue();
                    BigInteger bigMaskOneBit = BigInteger.valueOf(1).shiftLeft(nbLeastSignificantBit);
                    long maskOneBit = bigMaskOneBit.longValue();

                    long bitValueToSet = getMaskedValue(tmpValueToAdd, maskOneBit);
                    maskedValue = maskedValue | bitValueToSet << nbLeastSignificantBit;
                    nbLeastSignificantBit++;
                }
            }
        return maskedValue;
    }