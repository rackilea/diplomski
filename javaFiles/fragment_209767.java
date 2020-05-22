// declare array of Attendees, capacity is 20
// I would rather use ArrayList, but it seems you're trying to use array
String attendees[] = new String[20];

// delcare wait list
String waitList[] = new String[2];

// declare int for tickets sold
int ticketsSold = 0;
// declare waitlist
int waitlistCount = 0;

// prompt buyers for purchase of tickets
// ticketsSold = ticketsSold +  1 or 2 depending on tickets
// if ticketsSold is 20 do not sell tickets and send to waiting list
// Do this until full

// if ticketsSold = 20
// prompt user to go on wait list
// if yes, ask how many tickets
// if tickets requested for waitlist exceeds current waitlist + tickets requested
       // System.out.println("Sorry, waitlist is full");
// else prompt for user name
String name = in.nextLine();
waitlist[waitListCount] = name;

// here's the part I think you're having problems with
// if person is deleted from attendees
// get name of person not attending
int i = 0;
while (!cancelledName != attendees[i]) {
    i++
}

// replace attendees index with waitlist Name
attendees[i] = waitlist[0];

// move the waitlist forward
waitlist[0] = waitlist[1];
waitlist[1] = null;