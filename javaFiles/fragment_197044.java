this( false);
A() ---------------> A(false)
^                    ^
|                    |
| super();           | super( true ); <--- Problem: should the parameter be true or false? 
|                    |
|     this();        |
B() <--------------- B(5)  <--- you start here