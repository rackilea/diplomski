...

int min1, min2;

if (a2 == 0 || (a1 < a2 && a1 != 0))
  min1 = a1;
else
  min1 = a2;

if (a4 == 0 || (a3 < a4 && a3 != 0))
  min2 = a3;
else
  min2 = a4;

if (min1 == 0 || (min2 < min1 && min2 != 0))
   min1 = min2;

if (min1 == 0 || (a5 < min1 && a5 != 0))
  min1 = a5;

return min1;