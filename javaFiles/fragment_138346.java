@Override
public Complex mul(Complex b) {
    double real = this.r;
    double imaginary = this.i;
    this.r = real * b.r - imaginary * b.i;
    this.i = real * b.i + imaginary * b.r;
    return this;
}