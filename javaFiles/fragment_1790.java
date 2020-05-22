bool done = false;
while (!done)
{
   try {
      // Get the age
      if (valid) { done = true; }
   }
   catch { // ...
       // Handle the exception make sure done is still false
   }
} // End while