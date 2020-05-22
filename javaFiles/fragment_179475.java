int random = (int )(Math.random() * 1 + 0 );
PassengerComponent PC1;
if( random == 0)
{
    PC1 = new PassengerComponent("Passenger Component #1" , 0);    
}
else
{
    PC1 = new PassengerComponent("Passenger Component #1" , 1); 
}

PC1.ready_check(Sc, Cg);