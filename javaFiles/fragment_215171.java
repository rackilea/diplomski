int y = c.getLength();
while(i <= y-1 )
{
    int time = c.genes[i].time;
    if (time >= 16 && time <= 25)   {                           
        violations = violations + 1;        
    } 
    i++;
}