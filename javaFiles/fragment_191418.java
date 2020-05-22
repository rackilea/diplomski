for(divisor = (int)Math.sqrt(num); divisor>0; divisor--){
    if(num%divisor==0){
        divisor1 = num/divisor;
        break;
    }
}