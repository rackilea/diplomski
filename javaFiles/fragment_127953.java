for(Seat seat : seatsList){ //or whatever object type is in seatsList
  boolean seatHasPreferenceAtTable = false;
  for(Preference preference : seat.getPrefArrayList()){//or whatever object type is in getPrefArrayList()
    for(Seat otherSeat : seatsList){
      if(otherSeat.getName().equals(preference.getName())){
        seatHasPreferenceAtTable = true;
      }
    }
  }
}