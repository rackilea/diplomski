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

    public String toString() { 
       return "" + value + "";
    }
}