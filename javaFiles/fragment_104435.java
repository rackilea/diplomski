// Input number - 1001:
int n=9;
int position=0;
// Cache the input number - the loop destroys it.
int originalN=n;

while( n!=0 ){
    position++; // Also position = position + 1;
    n = n>>1; // Shift the bits over one spot (Overwriting n).
    // 1001 becomes 0100, then 0010, then 0001, then 0000 on each iteration. 
    // Hopefully you can then see that n is zero when we've 
    // pushed all the bits off.
}

// Position is now the point at which n became zero.
// In your case, this is also the value of your truncated binary log.
System.out.println("Binary log of "+originalN+" is "+position);