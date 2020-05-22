case HALF_UP:
            if (digits[maximumDigits] >= '5') {
                // We should not round up if the rounding digits position is
                // exactly the last index and if digits were already rounded.
                if ((maximumDigits == (count - 1)) &&
                    (alreadyRounded))
                    return false;

                // Value was exactly at or was above tie. We must round up.
                return true;
            }
            break;
        case HALF_DOWN:
            if (digits[maximumDigits] > '5') {
                return true;
            } else if (digits[maximumDigits] == '5' ) {
                if (maximumDigits == (count - 1)) {
                    // The rounding position is exactly the last index.
                    if (allDecimalDigits || alreadyRounded)
                        /* FloatingDecimal rounded up (value was below tie),
                         * or provided the exact list of digits (value was
                         * an exact tie). We should not round up, following
                         * the HALF_DOWN rounding rule.
                         */
                        return false;
                    else
                        // Value was above the tie, we must round up.
                        return true;
                }

                // We must round up if it gives a non null digit after '5'.
                for (int i=maximumDigits+1; i<count; ++i) {
                    if (digits[i] != '0') {
                        return true;
                    }
                }
            }
            break;