//public Static Character chooseClass() {
public Character chooseClass() { //you might need to make this method static. not too sure
    String char_type = "Mage"; //you would get the player they want using Scanner i think it is.
    switch(char_type){    
        case "Mage":    
            return new Mage();
        case "Archer":    
            return new Archer();
        default:
            System.out.println("Error that play doesnt exist!")
   }
    return null;
}