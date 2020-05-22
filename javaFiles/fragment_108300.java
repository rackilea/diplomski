if (jobDescription.equalsIgnoreCase("Programmer")) {
   // p must be of type Programmer to call addTechnology method
   Programmer p = new Programmer(name, ssn);
   for (String tech : technologies) {
      p.addTechnology(tech);
   }
   System.out.println(p.toString());
}