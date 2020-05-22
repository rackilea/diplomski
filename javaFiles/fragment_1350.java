int cpt = 0
for(Profile p : list_profiles){
   if(cpt++ == row){
      // return value corresponding to profile      
   }else{
      for(User u: p.getListUsers()){
         if(cpt++ == row)
             // return value corresponding to user     
      }
   }
}