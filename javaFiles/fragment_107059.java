int x,y;
x = 2;
y = x; //x = 2, y = 2
x = 3; //x = 3, y = 2 - Changing x does not change y

Object a,b;
a = new MyObject("foo"); //Create Object O on the heap, a = [Address of Object O]
b = a; //a = [Address of Object O], b = [Address of Object O]
a.updateValue("barr"); //Update a property of Object O
//a and b still contain [Address of Object O], but Object O has a new value.
a = new MyObject("Bazz"); //Create Object P, a = [Address of Object P]
//a = [Address of Object P], b = [Address of Object O]