recursivePower(base, exp):
    if (exp == 0) 
        return 1;
    if (exp == 1)
        return base;
    if (exp%2 == 0) {
        temp = recursivePower(base, exp/2);
        return temp*temp;
    temp = recursivePower(base, (exp-1)/2);
    return temp*temp*base;