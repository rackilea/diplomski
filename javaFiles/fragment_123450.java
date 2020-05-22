Point pointWeAreChecking;
Point centerOfCircle;
double radius;




if(Math.pow(Math.pow(pointWeAreChecking.x-centerOfCircle.x , 2) + Math.pow(pointWeAreChecking.y-centerOfCircle.y , 2), 0.5) <= radius)
{
//Means we are in circle.
if(pointWeAreChecking.y>pointWeAreChecking.x)
{
//Means it is either in 2 or 3 (it is below y = -x line)
if(pointWeAreChecking.y>-pointWeAreChecking.x + this.getHeight()){
//We are in 2.
}else
{
//We are in 3.    
}
}else
{
if(pointWeAreChecking.y>-pointWeAreChecking.x + this.getHeight())
{
//We are in 4.
}else
{
//We are in 2.
}
}

 }