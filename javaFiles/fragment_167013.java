class Car{
   public int year;
   public int name;
}

// Object variables are references to an object's data.

Car a = new Car(); // first car object and variable. 
a.year = 1990;
a.name = "Sam";

Car b = new Car();// second car object and variable
b.year = 2000;
b.name = "Bob";

Car c = a; // third car **variable** but same car object as **a**

// primitives are different

int a = 23; // first variable, 4 bytes used
int b = 45; // second variable, 4 bytes used (and a total of 8)
int c = a;  // third variable, 4 bytes used (and a total of 12). c took on the value of a, but does not point to the same memory as a