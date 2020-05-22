// The Square Root of Two, to 30 digits
// According to "The Square Root of Two, to 5 million digits."
// Source: http://www.gutenberg.org/files/129/129.txt
System.out.println("1.41421356237309504880168872420");

// Using JScience with 50 digits precision
Real.setExactPrecision(50);
System.out.println(Real.valueOf(2).sqrt());

// Using default java implementation
System.out.println(Math.sqrt(2));

> 1.41421356237309504880168872420
> 1.414213562373095048801689
> 1.4142135623730951