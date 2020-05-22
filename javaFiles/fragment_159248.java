class Example implements Comparable<Example> {

   @Nullable
   private String member;

   // TODO: getter, setter, constructor, ...

   public int compareTo(Example that) {
      if(this.member == null)
         if(that.member == null)
            return 0; //equal
         else
            return -1; // null is before other strings
       else // this.member != null
         if(that.member == null)
            return 1;  // all other strings are after null
         else
            return this.member.compareTo(that.member);
   }
}