//Declare this before you need to use it
java.util.Random rng = new java.util.Random(); //Provide a seed if you want the same ones every time
...
//Then, when you need a number:
long first14 = (rng.nextLong() % 100000000000000L) + 5200000000000000L;
//Or, to mimic the Math.random() option
long first14 = (rng.nextDouble() * 100000000000000L) + 5200000000000000L;