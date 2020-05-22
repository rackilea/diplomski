factorial(p,q) {
   if (there is result for (p,q) in the map)
      return it
   else
   {
      normal computation (provokes two child invocations)
      save result into cache
   }
}