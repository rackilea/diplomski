index = index + 1;   // now it is 1 based index and our formula would fit in nicely.
index = index * 2;
sqroot = integer part of square root of index;
if( sqroot * (sqroot+1) == index)
  print 1;
else 
  print 0;