for(int i = 0; i <= n; i++) {

    int product = 0;

    coefficient = factorial(n) / (factorial(i) * factorial(n - i));
    product = (int) (coefficient*Math.pow(a, n - i)*Math.pow(b, i));

    products.add(product);
}