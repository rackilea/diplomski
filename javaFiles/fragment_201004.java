private int xcoord, ycoord; 
private int identification; 
private double rate; 
private double traveled; 
private double timeSpent;

//Sets up a robot with the given ID number and beginning x and y coordinates
public Robot (int id, int x, int y) 
{
  identification = id;
  xcoord = x;
  ycoord = y;
  traveled = 0;
  rate = 5.0;
}

//Has the robot travel to the set coordinates
public double setDestination (int x, int y)
{
  double distance = Math.pow(x - xcoord, 2) + Math.pow(y - ycoord, 2);
  traveled += Math.sqrt(distance);
  xcoord = x;
  ycoord = y;
  timeSpent += Math.sqrt(distance)/rate;
  return traveled;
}

//Gets the time spent travelling
public double getTimeSpent()
{
  return timeSpent;
}

//Sets the rate at which the robot travels
public void setRate(double setrate)
{
  rate = setrate;
}

//Returns the ID of the robot
public int getID()
{
  return identification;
}