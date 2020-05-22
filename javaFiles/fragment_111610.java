public class Flight {

    //fields
    public int passengers;
    private int seats = 150;
    private int checkedBags;

    //The problem is here:  maxCarryOns in intialized to 0.
    //private int maxCarryOns = checkedBags*2;
    //change to say:
    private int maxCarryOns = seats*2;

    private int totalCarryOns;
    private int freeCheckedBags;

    //getter/setters
    public int getSeats(){return 150;}
    public int getCheckedBags() {return checkedBags;}

    //constructors
    public Flight (){}

   //removed 2 more constructors , not needed to demonstrate the problem


    //methods

    //removed, not needed to demonstrate the problem
    //public void addPassengers(Passenger... list) {

    public void add1Passenger(){
        if(hasSeats()) {
            passengers +=1;
        } else {
            tooMany();
        }
        return;
    }

    public void add1Passanger(int bags){
        if(hasSeats()) {
            add1Passenger();
            checkedBags+=bags;
        }
    }

    //removed, not needed to demonstrate the problem
    //public void add1Passenger(Passenger p)

    public void add1Passenger(int bags, int carryOns){

        if(hasSeats() && hasCarryOnSpace(carryOns)){

            add1Passanger(bags);
            totalCarryOns+=carryOns;
        }
    }

    public void add1Passenger(Passenger p, int carryOns){

        add1Passenger(p.getCheckedBags(), carryOns);
    }

    public boolean hasCarryOnSpace(int carryOns){

        //a simple printout here would hae revealed that 
        //maxCarryOns was 0, hencethis methos always returned false.
        return (totalCarryOns+carryOns) < maxCarryOns;
    }

    public boolean hasSeats(){

        return passengers < getSeats();
    }

    //removed, not needed to demonstrate the problem
    //private boolean hasSeats(int count) {

    private void tooMany(){
        System.out.println("no more seats available");
    }

    //main method
    public static void main(String[] args ){

        Flight usAir = new Flight();

        //removed all statements which are not needed to demonstrate the problem
        Passenger nick = new Passenger(0,2);

        //calls below don't increment the passenger count
        usAir.add1Passenger(nick, 2);
        usAir.add1Passenger(1, 1);
        System.out.println("usAir has " + usAir.passengers
                + " passengers " + "with " + usAir.getCheckedBags()+
                " checked bags,"+" "+usAir.freeCheckedBags
                +" free bags, and "+usAir.totalCarryOns+" carryOns on board");
   }
}

//include all needed to run the code
class Passenger {

    int freeBags =0, checkedBags =0;

    Passenger(int freeBags, int checkedBags){

        this.freeBags = freeBags;
        this.checkedBags = checkedBags;
    }

    /**
     *@return
     */
    public int getCheckedBags() {

        return  checkedBags;
    }
}