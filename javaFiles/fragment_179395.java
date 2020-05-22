public void newMethod(){
 for (int i = 0; i < DoorAmount; i++) {
 if (WinningDoorAmount > 0) {
    winnerSelect = (int) Math.round( Math.random());
    DoorArray[i] = winnerSelect;
    if(winnerSelect == 1) {
        WinningDoorAmount--;
    }
  }
 }
 else {
    DoorArray[i] = 0;
 }
  DoorAmount--;
}