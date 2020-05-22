void generate(){
    double sign = 1.0; double term;
    for (int i = 1; i<=n; i++){
        term = (sign * i) / fact(i+1);
        sum += term;
        sign *= -1;
    }
}