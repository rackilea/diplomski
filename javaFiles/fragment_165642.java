import javax.swing.JOptionPane;
String input=JOptionPane.showInputDialog("Steps");
int x=Integer.parseInt(input);
if (x<0)
{
    System.out.println("Error. Invalid Entry.");
}
int T=1;
int N=0;
double totalDistance = 0.0;//keep track over over distance;
while (T<10)
{
    while (N<x)
    {
        int stepsX=Math.round(random(1,10));
        int stepsY=Math.round(random(1,10));
        System.out.println(stepsX+","+stepsY);
        N=N+1;
        if (N==x)
        {
            int distance=(stepsX*stepsX)+(stepsY*stepsY);
            totalDistance = totalDistance + distance;
            System.out.println("current distance:  " + distance);
            System.out.println("current total distance:  " + totalDistance);
        }
    }
    T=T+1;
    N=0;
}
//calculate whatever you need using totalDistance
System.out.println("mean sq. dist = " + (totalDistance/T) );