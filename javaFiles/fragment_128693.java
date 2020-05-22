//in case user inserts a string/char instead of a double => error
} catch (Exception e){
   System.err.println("Nu ati introdus un numar.");
   //clear pending input.
   if (input.hasNext()) {
        input.next();
   }
   continue;
}