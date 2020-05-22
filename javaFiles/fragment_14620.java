private static class AssassinNode {
   private String player; 
   private String killer; 
   private AssassinNode next;

   private AssassinNode(String name){
       AssassinNode.player = name; 
       AssassinNode.killer = null; 
       this.next = null;
  } 
}// End of