public static long scall = 1000;
boolean equals(BucketEntity that)
{
   if (this == that) return true;
   if (this.x / scall == that.x / scall &&
       this.y / scall == that.y / scall)
      return true;
   return false;
}

// Maybe an 'int' is not enough to correctly hash your data
// if so you have to create you own implementation of Map
// with a special "long hashCode()" support.
int hashCode()
{
     // We put the 'x' bits in the high level, and the 'y' bits in the low level.
     // So the 'x' and 'y' don't conflict.
     // Take extra-care of the value of 'scall' relatively to your data and the max value of 'int'. scall == 10000 should be a maximum.
     return (this.x / scall) * scall + (this.y / scall);
}