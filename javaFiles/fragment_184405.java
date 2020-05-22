if (x % 2 == 0)
    x = x / 2;
else
    x = x * 3 + 1;
if (x < 0) {   
    System.out.print("The integer " + count + " cannot have its Hailstone sequence computed using int variables. ");
    return;
}