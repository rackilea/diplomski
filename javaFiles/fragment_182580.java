//print male students:
for (int i=0; i<studije.length; i++) {
   if(studije.gender == 'm'){ // replace "gender" with your attribute for gender in class Students
       System.out.println(studije[i].ime + " " +  studije[i].prezime + " iz " + studije[i].mestoRodjenja + ".")
   }
}

//print female students:
for (int i=0; i<studije.length; i++) {
   if(studije.gender == 'z'){ // replace "gender" with your attribute for gender in class Students
      System.out.println(studije[i].ime + " " +  studije[i].prezime + " iz " + studije[i].mestoRodjenja + ".")
   }
}