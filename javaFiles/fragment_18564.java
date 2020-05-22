String name = "FooBar";
int index = 7;
char holder = '';
if(index < name.length())     // check, String length must be greater than index
    holder = name.charAt(index) ;
else
    // print invalid index or other stuff