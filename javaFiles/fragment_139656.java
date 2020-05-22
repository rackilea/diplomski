class Dice{
    int value;
    Dice(){
        value=0;
    }
    void role(){
        int role;
        role = (int)(Math.random()*6+1);
        value=role;
    }   

    public int getValue() { 
       return value;
    }
}

//.. in other class:
System.out.println ("Dice: "+ Dices[1].getValue());