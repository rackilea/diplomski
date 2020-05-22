new TreeSet(new Comarator<Post>{
   public in compare(Post o1, Post o2){
       //o2.compareTo(o1) instead of o1.compareTo(o2) makes it reverse
        return o2.compareTo(o1);
   }
})