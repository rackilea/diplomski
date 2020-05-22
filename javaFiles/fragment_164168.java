@Transactional(propagation = REQUIRED)
public void reset(){
    clearDb();
    fillApples();
    fillBananas();
    //more fill methods
  }