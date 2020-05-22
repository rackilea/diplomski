while (first/10 == 0) {
    first = first % 10;
     if (first == second)
        return true;
  }
  if(first%10 == second)
     return true;

return false;