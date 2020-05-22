public double findProduct(int limit) { 
    double product = 1;
        for(int n = 3; n < limit; n = n + 3) {
            if (n%5 != 0)
        {
                product = product * n;
            }
       }
    return product;
}