public float power(float a, long n) {
        if (n > 0) {
            for (int i = 0; i < n; ++i) {
                a = a * n;
            }

            return a;
        } else if (n < 0) {
            for (int i = 0; i < n; ++i) {
                a = a * n;
            }
            a = 1 / a;
            return a;
        }else{
            return 0f;
        }
    }