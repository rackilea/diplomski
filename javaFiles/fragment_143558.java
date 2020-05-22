mi = 0
for each value x taken by f1:
{  sum = 0
   for each value y taken by f2:
   {  p_xy = number of examples where f1=x and f2=y
      p_x = number of examples where f1=x
      p_y = number of examples where f2=y
      sum += p_xy * log(p_xy/(p_x*p_y))
   }
   mi += sum
}