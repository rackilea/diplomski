boolean isPrime = true;
for( . . . ) {
    if( . . . ) {
        isPrime = false;
        break;
    } else {
        continue;
    }
}

if(isPrime) {
    System.out.println("It is prime!");
} else {
    System.out.println("It is not prime!");
}