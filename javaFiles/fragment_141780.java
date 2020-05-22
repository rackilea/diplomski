class State {
   private Integer flow; // nullable

   public Optional<Integer> getFlow(){
      return Optional.ofNullable(flow);
   }

}