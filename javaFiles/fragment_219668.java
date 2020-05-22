public static void main(String[] args)
{
    TryCatchExample.problem2(null);  // prints NPE
    TryCatchExample.problem2("A"); // prints numberformat
    // no example for both numberformat and npe
    TryCatchExample.problem2("5"); // prints lengths & value 5
}