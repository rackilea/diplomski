public int mySqrt(int x) {
        long i = 0;
        long j = x;
        int mid = 0;
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        while (i <= j) {
            mid = (int)(i + j)/2;
            if (x/mid == mid) {
                return (int)mid;
            } else if (x/mid > mid) {
                i = mid + 1;
            } else if (x/mid < mid) {
                j = mid - 1;
            }
        }
        return (int)j;
        }