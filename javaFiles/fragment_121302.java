MutableInteger a = new MutableInteger();
a.value = 5;

MutableInteger b = a;
b.value++;

a.value++;

//since a.value is the same primitive as b.value, they are both 7