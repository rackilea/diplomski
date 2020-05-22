Boolean hasIntersected = false;

[...] //Do some calculation of angle between minutes/hours. keep the sign, i.e. negative before intersection.

//Assuming that there's one intersection each hour, we reset the boolean every hour
if(minutes == 0 && seconds == 0)
    hasIntersected = false;

if(!hasIntersected && angle >= 0){
    hasIntersected == true;
    System.out.println("Output timestamp here or something");
}