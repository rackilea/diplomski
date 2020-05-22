class Combination {
Change changes[];

  void reset() { for (Change c: changes) c.reset();}

  boolean next() {
   for ( int i=0; i<changes.length; i++)
      if ( changes[i].isMax())
         changes[i].reset(); // next change will be taken in cycle, with "next()"
      else {changes[i].next(); return true;}

   return false; // all changes are max
  }
}