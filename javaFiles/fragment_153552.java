void checkIn(Guest guest){

   for (int i=0; i<rooms.length; i++){

     Room room = rooms[i];

      if(room.getGuest() == null){
         room.setGuest(guest);
         return;
       }
     }
  }