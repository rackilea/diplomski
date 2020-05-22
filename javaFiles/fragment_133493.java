/**
     * Calculate the offset     * 
     * @param i
     * @return array: 
     * 0: x offset
     * 1: y offset
     */
    private int[] calculateOffSet(int i) {
        int[] val = new int[2];
        int deflt = -12;
        if(i == 12) {
            val[0] = -15;
            val[1] = 9;
        }else if (i > 6) {
            val[0] = deflt + i - 6 ;
            val[1] = i ;
        }else {
            val[0] = deflt + i ;
            val[1] = i + 6;         
        }
        return val;
    }