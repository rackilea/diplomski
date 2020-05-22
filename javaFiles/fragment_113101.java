public int caughtSpeeding(int speed, boolean isBirthday) {
  int noTicket = 0;
  int smallTicket = 1;
  int bigTicket = 2;

  if (isBirthday && speed <= 65) {
      return noTicket;
  } else if (isBirthday && speed >= 66 && speed <= 86) {
      return smallTicket;
  } else if(isBirthday && speed >= 86) {
      return bigTicket;
  } else if (speed <= 60) {
      return noTicket;
  } else if (speed >= 61 && speed <= 80) {
      return smallTicket;
  } else if (speed >= 81){
      return bigTicket;
  } else{
      return 8;
  }
}