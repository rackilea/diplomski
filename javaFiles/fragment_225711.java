private static long getMaskedValue(long maskedValue, long mask){
        long definitiveMaskedValue = 0;
        int count=0;

        maskedValue = mask & maskedValue;

        while (mask != 0){
            while ((mask & 1) == 0){
                mask = mask >>> 1;
                maskedValue = maskedValue >>> 1;
            }
            while ((mask & 1) == 1){
                definitiveMaskedValue = definitiveMaskedValue + ((maskedValue & 1) << count);
                count++;

                mask = mask >>> 1;
                maskedValue = maskedValue >>> 1;
            }
        }

        return definitiveMaskedValue;
    }