for(Family p : existPatList) {
   System.out.println("Last name" +p.getLastName());             
   System.out.println("First name"+p.getFirstName());
   if(p.getFirstName().equalsIgnoreCase(patFamily.getFirstName()) && p.getLastName().equalsIgnoreCase(patFamily.getLastName())) {
       System.out.println("got it");       
   }
}