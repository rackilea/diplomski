private static Map<String,Integer> arr = new HashMap<>(  );

public static void main(String args[]){

    applesEaten("bob",5);
    applesEaten("bob",9);
    applesEaten("bob",5);
    applesEaten("Lisa",3);
    applesEaten("Lisa",5);
    applesEaten("Rob",7);
}
public static int applesEaten(String name, int apples)
{
    return arr.compute(name, (k,v) -> (v == null) ? apples : v+apples );
}