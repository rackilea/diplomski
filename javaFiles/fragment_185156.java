import java.util.Scanner;
public class circleOfCodeG{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int  r,x,y;
    double dis;
    r=sc.nextInt();
    x=sc.nextInt(); y=sc.nextInt();
    dis=Math.sqrt((x*x)+(y*y));
    if(dis<=r)
        System.out.println("The point ("+x+", "+y+") is inside the circle");
    else
        System.out.println("The point ("+x+", "+y+") is outside the circle");
}
}