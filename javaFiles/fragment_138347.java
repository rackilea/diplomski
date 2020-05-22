@Override
public Complex mul(Complex b) {
    double real = this.r;
    double imaginary = this.i;
    double real_b = b.r;
    double imaginary_b = b.i;
    this.r = real * real_b - imaginary * imaginary_b;
    this.i = real * imaginary_b + imaginary * real_b;
    return this;
}