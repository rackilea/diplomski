long overflowCheck;
if(Math.sign(value1) == Math.sign(value2)) {
   overflowCheck = Long.MAX_VALUE 
} else {
  overflowCheck = Long.MIN_VALUE;
}

if (value1 != 0 && (value2 > 0 && value2 > overflowCheck / value1 ||
    value2 < 0 && value2 < overflowCheck / value1))
{
   isOverflow = true; 
}