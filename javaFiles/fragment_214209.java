boolean isFound = false;
for(Book s : books){
    if(s.getYear()==year){
      isFound = true;
    }
}
if(!isFound) {
   System.out.println("No match");
}