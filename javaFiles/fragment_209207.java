//The first thing we do is setup the loop to iterate through the fib numbers.
//This looks good.
for (int i = 0; i < febCount; i++) {
 //Here we print out the fibonacci number we are on, unconditionally.
 //This means that every fibonacci number will be printed no matter what number it is
 //we don't want that.
 System.out.print(feb[i] + ((i % 10 == 9) ? "\n" : " "));
 //After we print the number, we check to see if it is a multiple of three.
 //maybe we should be waiting to print until then?
 if (feb[i] % 3 == 0)
  System.out.print("skip");
}