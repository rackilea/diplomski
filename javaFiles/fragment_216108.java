public void setRandomAge(){
    System.out.println(personsType); //The type of this person, for debugging purposes to 
                                     //make sure it's valid at this point
    if(personsType.equals("teen")){
        age = (int)(Math.random() * 4) + 13); //random number between [13,17], inclusive
    } 
    else if(personsType.equals("young adult")){
        age = (int)(Math.random() * 12) + 18; //random number between [18,30], inclusive
    }
    else if(personsType.equals("adult")){
        age = (int)(Math.random() * 18) + 31; //random number between [31, 49], inclusive
    }
    else if(personsType.equals("elder")){
        age = (int)(Math.random() * 50) + 50; //random number between [50, 100], inclusive
    }
    else{
        age = 0; //Probably should have some default case for 
                 //if the personsType is some other string
   }
}