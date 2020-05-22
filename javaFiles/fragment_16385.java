public class values {
    public static String clear = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static String username;
    public static int atk = 1;
    public static int hp = 10;

    private stats[] enemies;

 // .. your other code
public void sValues () // this method should not be static
{ //sValue method 
    // .. other code
    enemies = new stats [3];  // Remove the declaration at the start of this line
    // .. other code
}

public stats[] getEnemies()
{
    return enemies;
}