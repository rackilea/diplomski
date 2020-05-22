public Rational multiply(Long factor) {
    double d = this.numerator / (double) this.denumerator;
    if(Integer.MAX_VALUE % d < factor){
        //overflow
    } else if (this.numerator * factor < this.numerator){
        //overflow
    }else{
        this.numerator *= factor;
   }
}