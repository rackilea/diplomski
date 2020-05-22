public void plotPoints(Scanner keyboard)
{
    int x = 0, y = 0;
    while (true)
    {
        System.out.print("Enter an x and y coordinate: ");
        x = keyboard.nextInt(); 
        y = keyboard.nextInt();
    if(( x < 0 || x > 290) || (y < 0 || y > 290)) break;
        new Circle(x,y);
    }
    System.out.print("Done");
}