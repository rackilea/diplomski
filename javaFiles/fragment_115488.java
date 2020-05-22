float ac[50], bc[50];

inline float dotc() {
    float sum = 0;
    for (int i = 0; i < 50; i++) {
        sum += ac[i]*bc[i];
    }
    return sum;
}