import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        Vector speeds = new Vector();
        speeds.add("x");
        speeds.add("y");

        long estimated = 1l;
        long time = speeds.size() + estimated;
        System.out.println(time); // Prints out 3
    }
}