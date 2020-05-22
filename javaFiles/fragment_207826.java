Object x = 300;
Object y = 500;
Object z = x;

//here, x = 300, y = 500, z = 300

x = y;
//now, x = 500, y = 500, z = 300
//because the actual object that x initially pointed to was not changed, only x as a reference was changed.