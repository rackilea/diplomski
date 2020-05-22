//instance of your ship object
StarShip myShip = StarShip();
//method to add data to your TextArea
private void showShipInfo(){
    //getStarShip returns the list of ships
    //same as the method on your Fleet class
    myShip.getStarShip().forEach(starShip ->{
        //add data to TextArea for each field of
        //StarShip object you want to display
        shipInfo.append(starShip.getName());
        //shipInfo.append(starShip.get....());
        //shipInfo.append(starShip.get....());
        }
    }