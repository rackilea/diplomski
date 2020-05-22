if (c<0){
    try{
    throw new ArithmeticException();
    }
    catch (ArithmeticException e) {
        System.out.println("yadonegoofed");
    }
}

// c is odd and > 0
return b * exp(b, c-1);