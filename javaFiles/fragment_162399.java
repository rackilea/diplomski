while (newMinutes > 60) // subtract 60 minutes, add an hour
{
    newMinutes -= 60;
    addHours += 1;
}
newHours = oldHours + addHours;

while (newHours > 12)
{
    newHours -= 12; 
}