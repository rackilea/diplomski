public int[] removeDimension(final int dim) {
        /**
         * flatArray - original row-major order 1D representative of ND matrix
         * dimLength - length of one side
         * dimCount - number of dimensions
         */
        final int[] result = new int[flatArray.length / dimLength];
        for (int i = 0; i < flatArray.length; i++) {
            /**
             * construct array of original indexes, used to fill this value.
             * replace dimension which should be removed with -1.
             */
            final int[] indexes = new int[dimCount];
            for (int j = (dimCount - 1), ti = i; j >= 0; j--) {
                indexes[j] = (j == dim) ? -1 : (ti % dimLength);
                ti /= dimLength;
            }

            /**
             * construct final index in N-1D matrix, just skip removed dimension.
             */
            int idx = 0;
            for (final int index : indexes) {
                if (index != -1) {
                    idx = (idx * dimLength) + index;
                }
            }
            // summarize values into cell
            result[idx] += flatArray[i];
        }
        return result;
    }