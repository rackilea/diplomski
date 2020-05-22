private static String[] arr = new String[3];

public static void main(String args[])
{
    arr[0] = "bob";
    arr[1] = "Lisa";
    arr[2] = "Rob";
    applesEaten("bob",5);
    applesEaten("bob",9);
    applesEaten("bob",5);
    applesEaten("Lisa",3);
    applesEaten("Lisa",5);
    applesEaten("Rob",7);
}
public static int applesEaten(String name, int apples)
{

    for ( int i = 0; i < arr.length; i++ )
    {
        String[] split = arr[i].split( "-" );
        if(split[0].equals( name ))
        {
            if(split.length==1)
            {
                arr[i]=name+"-"+apples;
                return apples;
            }
            else
            {
                int newApples = (Integer.parseInt( split[1] )+apples);
                arr[i]=name+"-"+newApples;
                return newApples;
            }

        }
    }
    return 0;
}