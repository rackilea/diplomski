public boolean HW2F(int sample[], int criminal[]) {

        for (int i = 0; i < sample.length; i++) {
            if (sample[i] != criminal[i]) {
                return false;
            }
        }
        return true;
    }